package br.com.entelgy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AdditionalIngridient implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Ingridient Ingridient;
	
	@ManyToOne
	private Snack snack;
	
	@ManyToOne
	private Invoice invoice;
	
	private Integer quantity;
	
	public Ingridient getIngridient() {
		return Ingridient;
	}
	public void setIngridient(Ingridient ingridient) {
		Ingridient = ingridient;
	}
	public Snack getSnack() {
		return snack;
	}
	public void setSnack(Snack snack) {
		this.snack = snack;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
