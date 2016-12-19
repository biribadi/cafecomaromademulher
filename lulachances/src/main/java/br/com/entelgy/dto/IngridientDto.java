package br.com.entelgy.dto;

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
	
	
	
	

}
