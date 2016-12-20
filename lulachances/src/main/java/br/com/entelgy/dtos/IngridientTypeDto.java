package br.com.entelgy.dtos;

import org.hibernate.validator.constraints.NotEmpty;

public class IngridientTypeDto {
	
	private Integer id;
	
	@NotEmpty
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
