package br.com.entelgy.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.entelgy.dtos.IngridientDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Snack implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	private DescriptionItem description;

	@Transient
	private BigDecimal price;

	@ManyToMany
	@JoinTable(name = "snacks_has_ingridients", joinColumns = { @JoinColumn(name = "snack_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ingridient_id") })
	private List<Ingridient> ingridients;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Ingridient> getIngridients() {
		return ingridients;
	}

	public void setIngridients(List<Ingridient> ingridients) {
		this.ingridients = ingridients;
	}

	public DescriptionItem getDescription() {
		return description;
	}

	public void setDescription(DescriptionItem description) {
		this.description = description;
	}
	
	public BigDecimal calculePrice(){
		BigDecimal value = BigDecimal.ZERO;
		if (!ingridients.isEmpty()){
			for (Ingridient ingridient : ingridients){
				value = value.add(ingridient.getPrice());
			}
		}
		return value;
	}
	
}
