package br.com.entelgy.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQuery(name = "Invoice.findInvoicesUndelivered", query = "SELECT i FROM Invoice i join i.delivery d"
		+ " WHERE d.isDelivered = false")
public class Invoice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany
    @JoinTable(name="invoice_has_snacks", 
    joinColumns= {@JoinColumn(name="invoice_id")}, 
    inverseJoinColumns= {@JoinColumn(name="snack_id")})
	private List<Snack> snacks;
	
	@ManyToOne(optional = false)
	private Payment formOfPayment;
	
	@ManyToOne(optional = false)
	private UserSnacks customer;
	
	@ManyToOne
	private Delivery delivery;
	
	private Calendar createdOn;
	
	private Boolean exchangeNeeded;
	
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Snack> getSnacks() {
		return snacks;
	}

	public void setSnacks(List<Snack> snacks) {
		this.snacks = snacks;
	}

	public Payment getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(Payment formOfPayment) {
		this.formOfPayment = formOfPayment;
	}
	
	public UserSnacks getCustomer() {
		return customer;
	}

	public void setCustomer(UserSnacks customer) {
		this.customer = customer;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getExchangeNeeded() {
		return exchangeNeeded;
	}

	public void setExchangeNeeded(Boolean exchangeNeeded) {
		this.exchangeNeeded = exchangeNeeded;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public BigDecimal calculePrice() {
		
		BigDecimal value = BigDecimal.ZERO;
		if (snacks != null && !snacks.isEmpty()){
			for (Snack snack : snacks){
				value = value.add(snack.calculePrice());
			}
		}
		return value;
	}

	
	
}
