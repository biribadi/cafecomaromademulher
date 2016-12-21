package br.com.entelgy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.entelgy.models.UserSnacks;

public interface UserRepository extends CrudRepository<UserSnacks, Integer>{
	
	UserSnacks findByEmail(String email);

}
