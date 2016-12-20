package br.com.entelgy.dtos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InvoiceDto {

	private Integer id;
	
	@NotNull
	private List<SnackDto> snacks;
	
	@NotNull
	private PaymentDto paymentDto;
	
	@NotNull
	@Min(0)
	private BigDecimal totalPrice;
	
	private Calendar createdOn;
	
	private Boolean isDelivered;
	
	@NotNull
	private Boolean exchangeNeeded;
	
	private Integer customerId;

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

	public Boolean getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public Boolean getExchangeNeeded() {
		return exchangeNeeded;
	}

	public void setExchangeNeeded(Boolean exchangeNeeded) {
		this.exchangeNeeded = exchangeNeeded;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}	
}
