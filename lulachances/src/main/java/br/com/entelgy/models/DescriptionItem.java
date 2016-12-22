package br.com.entelgy.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DescriptionItem implements Serializable{
	
	private static final long serialVersionUID = 3949730989840316855L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String wordEnUs;
	
	private String wordPtBr;
	
	@OneToOne(mappedBy="description")
	private Ingridient ingridient;
	
	@OneToOne(mappedBy="type")
	private IngridientType ingridientType;
	
	@OneToOne(mappedBy="description")
	private Snack snack;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWordEnUs() {
		return wordEnUs;
	}

	public void setWordEnUs(String wordEnUs) {
		this.wordEnUs = wordEnUs;
	}

	public String getWordPtBr() {
		return wordPtBr;
	}

	public void setWordPtBr(String wordPtBr) {
		this.wordPtBr = wordPtBr;
	}

	public Ingridient getIngridient() {
		return ingridient;
	}

	public void setIngridient(Ingridient ingridient) {
		this.ingridient = ingridient;
	}

	public IngridientType getIngridientType() {
		return ingridientType;
	}

	public void setIngridientType(IngridientType ingridientType) {
		this.ingridientType = ingridientType;
	}	
	
	

}
