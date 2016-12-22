package br.com.entelgy.dtos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class InvoiceDto {

	private Integer id;
	
	@NotNull
	private List<SnackDto> snacks;
	
	@NotNull
	private PaymentDto paymentDto;
	
	private BigDecimal totalPrice;
	
	@DateTimeFormat(pattern="dd/mm/YYYY")
	private Calendar createdOn;
	
	private Byte isDelivered;
	
	@NotNull
	private Byte exchangeNeeded;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<SnackDto> getSnacks() {
		return snacks;
	}

	public void setSnacks(List<SnackDto> snacks) {
		this.snacks = snacks;
	}

	public PaymentDto getPaymentDto() {
		return paymentDto;
	}

	public void setPaymentDto(PaymentDto paymentDto) {
		this.paymentDto = paymentDto;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public Byte getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Byte isDelivered) {
		this.isDelivered = isDelivered;
	}

	public Byte getExchangeNeeded() {
		return exchangeNeeded;
	}

	public void setExchangeNeeded(Byte exchangeNeeded) {
		this.exchangeNeeded = exchangeNeeded;
	}
}
