package br.com.entelgy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.entelgy.models.Ingridient;

@Service(value="ingridientService")
public interface IngridientService {
	
	List<Ingridient> findAll();

	void saveIngridient(Ingridient ingridients);

	boolean isIngridientAlreadyInserted(Ingridient ingridients);

	List<Ingridient> findAllByLocale(String language);

}
