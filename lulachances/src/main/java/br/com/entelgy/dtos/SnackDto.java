package br.com.entelgy.dtos;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SnackDto {
	
	private Integer id;
	
	private String description;
	
	@NotNull
	private List<IngridientDto> ingridients;
	
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

	public List<IngridientDto> getIngridients() {
		return ingridients;
	}

	public void setIngridients(List<IngridientDto> ingridients) {
		this.ingridients = ingridients;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
