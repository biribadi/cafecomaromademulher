package br.com.entelgy.utils;

import java.text.ParseException;
import java.util.Locale;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import br.com.entelgy.dtos.DeliveryDto;
import br.com.entelgy.dtos.IngridientDto;
import br.com.entelgy.dtos.InvoiceDto;
import br.com.entelgy.dtos.PaymentDto;
import br.com.entelgy.dtos.SnackDto;
import br.com.entelgy.models.Delivery;
import br.com.entelgy.models.Ingridient;
import br.com.entelgy.models.Invoice;
import br.com.entelgy.models.Payment;
import br.com.entelgy.models.Snack;

public class DtoHelper {
	
	static { modelMapper = new ModelMapper(); }
	
	private static ModelMapper modelMapper;
	
	public static IngridientDto convertToIngridientDto(Ingridient ingridient) {
		IngridientDto ingridientDto = modelMapper.map(ingridient, IngridientDto.class);
		if (LocaleContextHolder.getLocale().getLanguage().equals(Locale.ENGLISH.getLanguage())) {
			ingridientDto.setDescription(ingridient.getDescription().getWordEnUs());
			ingridientDto.getIngridientType().setType(ingridient.getIngridientType().getType().getWordEnUs());
		} else {
			ingridientDto.setDescription(ingridient.getDescription().getWordPtBr());
			ingridientDto.getIngridientType().setType(ingridient.getIngridientType().getType().getWordPtBr());
		}

		return ingridientDto;
	}

	public static SnackDto convertToSnackDto(Snack snack) {
		SnackDto snackDto = modelMapper.map(snack, SnackDto.class);
		if (LocaleContextHolder.getLocale().getLanguage().equals(Locale.ENGLISH.getLanguage())) {
			snackDto.setDescription(snack.getDescription().getWordEnUs());
		}else{
			snackDto.setDescription(snack.getDescription().getWordPtBr());	
		}
		snackDto.setPrice(snack.calculePrice());
		snackDto.setIngridients(snack.getIngridients().stream().map(ingridient -> convertToIngridientDto(ingridient)).collect(Collectors.toList()));
		return snackDto;
	}

	public static Snack convertToSnackEntity(SnackDto snackDto) throws ParseException {
		Snack snack = modelMapper.map(snackDto, Snack.class);
		// if (postDto.getId() != null) {
		// Post oldPost = postService.getPostById(postDto.getId());
		// post.setRedditID(oldPost.getRedditID());
		// post.setSent(oldPost.isSent());
		// }
		return snack;
	}
	
	public static PaymentDto convertToPaymentDto(Payment payment){
		PaymentDto paymentDto = modelMapper.map(payment, PaymentDto.class);
		if (LocaleContextHolder.getLocale().getLanguage().equals(Locale.ENGLISH.getLanguage())){
			paymentDto.setDescription(payment.getDescription().getWordEnUs());
		}else{
			paymentDto.setDescription(payment.getDescription().getWordPtBr());
		}
		return paymentDto;
	}
	
	public static InvoiceDto convertToInvoiceDto(Invoice invoice) {
		InvoiceDto invoiceDto = modelMapper.map(invoice, InvoiceDto.class);
		invoiceDto.setPaymentDto(convertToPaymentDto(invoice.getFormOfPayment()));
		if (invoice.getDelivery() != null){
			invoiceDto.setIsDelivered((byte)1);
		}else{
			invoiceDto.setIsDelivered((byte) 0);
		}
		invoiceDto.setTotalPrice(invoice.calculePrice());
		invoiceDto.setSnacks(invoice.getSnacks().stream().map(snack -> convertToSnackDto(snack)).collect(Collectors.toList()));;
		return invoiceDto;
	}
	
	public static Invoice convertToInvoiceEntity(InvoiceDto invoiceDto) throws ParseException {
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
	
	public static Delivery convertToDeliveryEntity(DeliveryDto deliveryDto) throws ParseException {
		Delivery delivery = modelMapper.map(deliveryDto, Delivery.class);
		
		return delivery;
	}
	
	public static DeliveryDto convertToDeliveryDto(Delivery delivery){
		DeliveryDto deliveryDto = modelMapper.map(delivery, DeliveryDto.class);
		return deliveryDto;
	}

}
