package br.com.entelgy.dtos;

import org.hibernate.validator.constraints.NotEmpty;

public class IngridientTypeDto {
	
	private Integer id;
	
	@NotEmpty
	private String description;

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
}
