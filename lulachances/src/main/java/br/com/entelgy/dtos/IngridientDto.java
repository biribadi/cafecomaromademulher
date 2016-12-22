package br.com.entelgy.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class IngridientDto {
	
	private Integer id;
	
	private String description;
	
	@NotNull
	private IngridientTypeDto ingridientType;
	
	private BigDecimal price;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String description_br;
	
	public String description_en;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription_br() {
		return description_br;
	}

	public void setDescription_br(String description_br) {
		this.description_br = description_br;
	}

	public String getDescription_en() {
		return description_en;
	}

	public void setDescription_en(String description_en) {
		this.description_en = description_en;
	}
}
