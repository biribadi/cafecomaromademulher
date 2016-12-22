package br.com.entelgy.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Delivery implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static Integer delivery_number = 0;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Calendar deliveryDate;
	
	private Integer deliveryNumber;
	
	private Boolean isDelivered;
	
	@OneToMany(mappedBy="delivery")
	private Set<Invoice> invoice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getDeliveryNumberNumber() {
		setDeliveryNumberNumber(delivery_number++);
		 return deliveryNumber;
	}

	public void setDeliveryNumberNumber(Integer deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public Boolean getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	
	public Set<Invoice> getinvoice() {
		return invoice;
	}

	public void setinvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}
}
