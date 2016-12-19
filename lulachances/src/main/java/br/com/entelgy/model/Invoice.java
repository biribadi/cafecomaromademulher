package br.com.entelgy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
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
	
	private BigDecimal totalPrice;
	
	@JoinColumn
	@ManyToOne(optional = false)
	private Payment formOfPayment;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Delivery develiry;
	
	private Calendar createdOn;

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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Payment getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(Payment formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Delivery getDeveliry() {
		return develiry;
	}

	public void setDeveliry(Delivery develiry) {
		this.develiry = develiry;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	
	
}
