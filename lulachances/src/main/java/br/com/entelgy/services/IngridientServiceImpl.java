package br.com.entelgy.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.entelgy.models.Ingridient;
import br.com.entelgy.repository.IngridientRepository;

@Transactional
@Component("ingridientService")
public class IngridientServiceImpl implements IngridientService{
	
	@Autowired
	private IngridientRepository repository;
	
	public Iterable<Ingridient> findAll(){
		return repository.findAll();
	}

	public void saveIngridient(Ingridient ingridient) {
		repository.save(ingridient);
		
	}

	public boolean isIngridientAlreadyInserted(Ingridient ingridients) {
		return false;
	}

}
