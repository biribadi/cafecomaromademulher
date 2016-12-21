package br.com.entelgy.dtos;

import org.hibernate.validator.constraints.NotEmpty;

public class IngridientTypeDto {
	
	private Integer id;
	
	@NotEmpty
	private String typeTranslated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeTranslated() {
		return typeTranslated;
	}

	public void setTypeTranslated(String typeTranslated) {
		this.typeTranslated = typeTranslated;
	}
	
}
