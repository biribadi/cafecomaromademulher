package br.com.entelgy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.entelgy.models.Snack;

public interface SnackDAO extends CrudRepository<Snack, Integer>{
	

}
