package br.com.entelgy.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SnackDto {
	
	private Integer id;
	
	@NotNull
	@NotEmpty
	private String description;
	
	@NotNull
	private List<IngridientDto> ingridients;
	
	@Min(0)
	private BigDecimal price;
	
	
	
	

}
