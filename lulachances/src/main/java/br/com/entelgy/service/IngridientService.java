package br.com.entelgy.service;

import org.springframework.stereotype.Service;

import br.com.entelgy.model.Ingridient;

@Service(value="ingridientService")
public interface IngridientService {
	
	Iterable<Ingridient> findAll();

	void saveIngridient(Ingridient ingridients);

	boolean isIngridientAlreadyInserted(Ingridient ingridients);

}
