package br.com.entelgy.services;

import java.util.List;

import br.com.entelgy.models.Delivery;

public interface DeliveryService {
	
	List<Delivery> findAll();
	
	Delivery save(Delivery delivery);

	Delivery getById(Integer id);

}
