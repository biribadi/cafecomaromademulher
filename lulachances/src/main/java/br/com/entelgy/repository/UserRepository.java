package br.com.entelgy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.entelgy.models.UserSnacks;

public interface UserRepository extends CrudRepository<UserSnacks, Integer>{
	
	List<UserSnacks> findAllUserByEmail(String email);
	
	
	

}
