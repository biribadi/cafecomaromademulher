package br.com.entelgy.models;

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
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Ingridient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private IngridientType ingridientType;
	
	@OneToOne
	private DescriptionItem description;
	
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DescriptionItem getDescription() {
		return description;
	}

	public void setDescription(DescriptionItem description) {
		this.description = description;
	}
}
