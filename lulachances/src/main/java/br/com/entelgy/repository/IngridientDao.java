package br.com.entelgy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.entelgy.models.Ingridient;

@RepositoryRestResource(collectionResourceRel = "ingridient", path = "ingridient")
public interface IngridientDao extends PagingAndSortingRepository<Ingridient, Integer>{

}
