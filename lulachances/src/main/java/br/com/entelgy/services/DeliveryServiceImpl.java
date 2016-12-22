package br.com.entelgy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entelgy.models.Delivery;
import br.com.entelgy.repository.DeliveryRepository;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	DeliveryRepository deliveryRepository;

	@Override
	public List<Delivery> findAll() {
		return (List<Delivery>) deliveryRepository.findAll();
	}

	@Override
	public Delivery save(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public Delivery getById(Integer id) {
		return deliveryRepository.findOne(id);
	}

}
