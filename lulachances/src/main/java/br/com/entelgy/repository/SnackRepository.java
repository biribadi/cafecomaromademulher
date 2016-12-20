package br.com.entelgy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.entelgy.models.Snack;

public interface SnackRepository extends CrudRepository<Snack, Integer>{
	
//	 /**
//     * Finds person by using the last name as a search criteria.
//     * @param lastName
//     * @return  A list of persons whose last name is an exact match with the given last name.
//     *          If no persons is found, this method returns null.
//     */
//    public List<Snack> findByName(String lastName);
	

}
