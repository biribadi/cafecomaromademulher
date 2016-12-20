package br.com.entelgy.controllers;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "invoices")
public class InvoiceController extends BaseController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<InvoiceDto>> getAllUndeliveredInvoice() {

		List<Invoice> invoices = invoiceService.findAllUndelivered();
		if (invoices == null) {
			return new ResponseEntity<List<InvoiceDto>>(HttpStatus.NO_CONTENT);
		}
		List<InvoiceDto> dtos = invoices.stream().map(invoice -> convertToInvoiceDto(invoice))
				.collect(Collectors.toList());
		return new ResponseEntity<List<InvoiceDto>>(dtos, HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<InvoiceDto> findInvoice(@PathVariable Integer id) {

		if (id <= 0) {
			return new ResponseEntity<InvoiceDto>(HttpStatus.BAD_REQUEST);
		} else {
			Invoice invoice = invoiceService.getById(id);
			if (invoice == null) {
				return new ResponseEntity<InvoiceDto>(HttpStatus.NO_CONTENT);
			} else {
				InvoiceDto dto = convertToInvoiceDto(invoice);
				return new ResponseEntity<InvoiceDto>(dto, HttpStatus.OK);
			}
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json" , consumes="application/json")
	public ResponseEntity<Void> saveInvoice(@Validated @RequestBody InvoiceDto invoiceDto, UriComponentsBuilder ucBuilder) throws ParseException{
		
		Invoice invoice = convertToInvoiceEntity(invoiceDto);
		invoiceService.save(invoice);
		URI resourcePath = ucBuilder.path("/invoices/{id}").buildAndExpand(invoice.getId()).toUri();
		return new ResponseEntity<Void>(mountHeader(resourcePath), HttpStatus.CREATED);
		
	}

	private Invoice convertToInvoiceEntity(InvoiceDto invoiceDto) throws ParseException {
		Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);

		// set user id
		// invoice.setCustomer(customer);
		// if (postDto.getId() != null) {
		// Post oldPost = postService.getPostById(postDto.getId());
		// post.setRedditID(oldPost.getRedditID());
		// post.setSent(oldPost.isSent());
		// }
		return invoice;
	}

	private InvoiceDto convertToInvoiceDto(Invoice invoice) {
		InvoiceDto invoiceDto = modelMapper.map(invoice, InvoiceDto.class);
		invoiceDto.setIsDelivered(invoice.getDeveliry().getIsDelivered());
		invoiceDto.setCustomerId(invoice.getCustomer().getId());
		return invoiceDto;
	}

}
