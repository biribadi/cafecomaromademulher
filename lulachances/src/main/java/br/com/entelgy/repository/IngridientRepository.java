package br.com.entelgy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import br.com.entelgy.models.Ingridient;

public interface IngridientRepository extends CrudRepository<Ingridient, Integer>{

}
