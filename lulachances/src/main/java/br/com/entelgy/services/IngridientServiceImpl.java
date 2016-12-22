package br.com.entelgy.services;

import java.util.List;

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
	
	public List<Ingridient> findAll(){
		return (List<Ingridient>) repository.findAll();
	}

	public void saveIngridient(Ingridient ingridient) {
		repository.save(ingridient);
		
	}

	public boolean isIngridientAlreadyInserted(Ingridient ingridients) {
		return false;
	}

	@Override
	public List<Ingridient> findAllByLocale(String language) {
		// TODO Auto-generated method stub
		return null;
	}

}
