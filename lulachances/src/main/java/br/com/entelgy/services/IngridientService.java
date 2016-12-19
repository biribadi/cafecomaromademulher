package br.com.entelgy.services;

import org.springframework.stereotype.Service;

import br.com.entelgy.models.Ingridient;

@Service(value="ingridientService")
public interface IngridientService {
	
	Iterable<Ingridient> findAll();

	void saveIngridient(Ingridient ingridients);

	boolean isIngridientAlreadyInserted(Ingridient ingridients);

}
