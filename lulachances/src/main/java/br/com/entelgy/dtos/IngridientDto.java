package br.com.entelgy.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class IngridientDto {
	
	private Integer id;
	
	@NotEmpty
	@NotNull
	private String description;
	
	@NotNull
	private IngridientTypeDto ingridientType;
	
	@Min(0)
	private BigDecimal price;

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

	public IngridientTypeDto getIngridientType() {
		return ingridientType;
	}

	public void setIngridientType(IngridientTypeDto ingridientType) {
		this.ingridientType = ingridientType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
