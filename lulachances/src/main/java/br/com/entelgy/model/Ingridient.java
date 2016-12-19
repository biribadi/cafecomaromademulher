package br.com.entelgy.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Ingridient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
//	@ElementCollection(targetClass = IngridientType.class, fetch = FetchType.EAGER)
//	@JoinTable(name = "ingredient_type", joinColumns = @JoinColumn(name = "ingredientid"))
//	@Column(name = "ingredienttype", nullable = false)
//	@Enumerated(EnumType.STRING)
	@ManyToOne
	private IngridientType ingridientType;
	
	private String description;
	
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IngridientType getIngridientType() {
		return ingridientType;
	}

	public void setIngridientType(IngridientType ingridientType) {
		this.ingridientType = ingridientType;
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
	
	
	
	
	
	

}
