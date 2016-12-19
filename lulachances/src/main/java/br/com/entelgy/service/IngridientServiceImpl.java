package br.com.entelgy.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.entelgy.model.Ingridient;
import br.com.entelgy.repository.IngridientDao;

public class IngridientServiceImpl implements IngridientService{
	
	@Autowired
	private IngridientDao repository;
	
	public Iterable<Ingridient> findAll(){
		return repository.findAll();
	}

	public void saveIngridient(Ingridient ingridients) {
		repository.save(ingridients);
		
	}

	public boolean isIngridientAlreadyInserted(Ingridient ingridients) {
		return false;
	}

}
