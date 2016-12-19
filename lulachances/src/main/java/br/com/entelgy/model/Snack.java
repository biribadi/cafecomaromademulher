package br.com.entelgy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Snack implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	
	@NotNull
	private BigDecimal price;
	
	@ManyToMany
    @JoinTable(name="snacks_has_ingridients", joinColumns=
    {@JoinColumn(name="snack_id")}, inverseJoinColumns=
     {@JoinColumn(name="ingridient_id")})
	private Set<Ingridient> ingridients;
		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<Ingridient> getIngridients() {
		return ingridients;
	}

	public void setIngridients(Set<Ingridient> ingridients) {
		this.ingridients = ingridients;
	}

}
