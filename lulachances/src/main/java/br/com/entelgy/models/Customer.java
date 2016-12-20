package br.com.entelgy.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(optional=false)
	private UserSnacks user;
	
	private String address;
	
	@OneToMany(mappedBy="customer")
	private Set<Invoice> invoice;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserSnacks getUser() {
		return user;
	}

	public void setUser(UserSnacks user) {
		this.user = user;
	}
}
