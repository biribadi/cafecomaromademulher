package br.com.entelgy.services;

import java.util.List;

import br.com.entelgy.models.Snack;

public interface SnackService {
	
	 /**
     * Finds all snacks
     * @return  A list of all snacks in database
     */
	List<Snack> findAll();
	
	 /**
     * Finds snack by using the id as a search criteria.
     * @param id
     * @return  The Snack of the id given
     */
	Snack findById(Integer id);
	
	 /**
     * Save snack sent by client .
     * @param lastName
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns null.
     */
	Snack save(Snack snack);
	
}
