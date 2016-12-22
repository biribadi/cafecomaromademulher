package br.com.entelgy.controllers;

import static br.com.entelgy.utils.DtoHelper.*;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entelgy.dtos.InvoiceDto;
import br.com.entelgy.models.Invoice;
import br.com.entelgy.services.InvoiceService;

@RestController
@RequestMapping(value = "v1")
public class InvoiceController  {

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value = "invoice",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllUndeliveredInvoice() {

		List<Invoice> invoices = invoiceService.findAllUndelivered();
		if (invoices == null || invoices.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		List<InvoiceDto> dtos = invoices.stream().map(invoice -> convertToInvoiceDto(invoice))
				.collect(Collectors.toList());
		return ResponseEntity.ok(dtos);

	}

	@RequestMapping(value = "invoice/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> findInvoice(@PathVariable Integer id) {

		if (id <= 0) {
			return ResponseEntity.badRequest().build();
		} else {
			Invoice invoice = invoiceService.getById(id);
			if (invoice == null) {
				return ResponseEntity.notFound().build();
			} else {
				InvoiceDto dto = convertToInvoiceDto(invoice);
				return ResponseEntity.ok(dto);
			}
		}
	}
	
	@RequestMapping(value = "invoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveInvoice(@Validated @RequestBody InvoiceDto invoiceDto, UriComponentsBuilder ucBuilder) throws ParseException{
		
		Invoice invoice = convertToInvoiceEntity(invoiceDto);
		invoiceService.save(invoice);
		URI resourcePath = ucBuilder.path("/invoice/{id}").buildAndExpand(invoice.getId()).toUri();
		return ResponseEntity.created(resourcePath).build();
	}

}
