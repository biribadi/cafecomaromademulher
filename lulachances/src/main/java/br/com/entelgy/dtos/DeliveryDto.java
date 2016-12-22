package br.com.entelgy.dtos;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class DeliveryDto {
	
	private Integer id;
	
	@DateTimeFormat(pattern="dd/mm/YYYY")
	private Calendar deliveryDate;
	
	private Integer deliveryNumber;
	
	private Boolean isDelivered;
	
	private List<InvoiceDto> invoices;
	
	public DeliveryDto(){
		
	}
	
	public DeliveryDto(List<InvoiceDto> invoices){
		this.invoices = invoices;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(Integer deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public Boolean getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public List<InvoiceDto> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<InvoiceDto> invoices) {
		this.invoices = invoices;
	}
}
