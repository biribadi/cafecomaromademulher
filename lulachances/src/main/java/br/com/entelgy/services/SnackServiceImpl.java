package br.com.entelgy.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.entelgy.models.Snack;
import br.com.entelgy.repository.SnackRepository;

@Component("snackService")
@Transactional
public class SnackServiceImpl implements SnackService{
	
	@Autowired
	private SnackRepository snackRepository;
	
	@Override
	public List<Snack> findAll() {
		return (List<Snack>) snackRepository.findAll();
	}

	@Override
	public Snack findById(Integer id) {
		return snackRepository.findOne(id);
	}

	@Override
	public Snack save(Snack snack) {
		return snackRepository.save(snack);
	}
	
}
