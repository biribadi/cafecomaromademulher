package br.com.entelgy.controllers;

import static br.com.entelgy.utils.DtoHelper.*;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entelgy.dtos.DeliveryDto;
import br.com.entelgy.dtos.InvoiceDto;
import br.com.entelgy.models.Delivery;
import br.com.entelgy.services.DeliveryService;

@RestController
@RequestMapping(value = "v1")
@PreAuthorize("hasRole('ADMIN')")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;

	@RequestMapping(value = "delivery", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createDelivery(@Valid @RequestBody List<InvoiceDto> invoicesToBeDelivery,
			UriComponentsBuilder ucBuilder) throws ParseException {

		DeliveryDto deliveryDto = new DeliveryDto(invoicesToBeDelivery);
		Delivery delivery = convertToDeliveryEntity(deliveryDto);

		deliveryService.save(delivery);

		URI resourcePath = ucBuilder.path("/v1/delivery/{id}").buildAndExpand(delivery.getId()).toUri();
		return ResponseEntity.created(resourcePath).build();

	}

	@RequestMapping(value = "delivery/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listDelivery(@PathVariable Integer id) {
		
		if (id <= 0) {
			return ResponseEntity.badRequest().build();
		} else {
			Delivery delivery = deliveryService.getById(id);
			if (delivery == null) {
				return ResponseEntity.notFound().build();
			} else {
				DeliveryDto dto = convertToDeliveryDto(delivery);
				return ResponseEntity.ok(dto);
			}
		}
		

	}

}
