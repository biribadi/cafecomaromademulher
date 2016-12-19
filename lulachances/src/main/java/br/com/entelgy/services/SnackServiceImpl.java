package br.com.entelgy.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.entelgy.dtos.SnackDto;
import br.com.entelgy.models.Snack;
import br.com.entelgy.repository.SnackDAO;

public class SnackServiceImpl {
	
	@Autowired
	private SnackDAO snackDao;
	
	public Snack retrieveSnackById(SnackDto snackDto){
		return snackDao.findOne(snackDto.getId());
	}
	
	public void teste(SnackDto snackDto){
		snackDao.save(toEntity(snackDto));
	}
	
	private Snack toEntity(SnackDto snackDto){
		Snack snack = new Snack();
		snack.setId(snackDto.getId());
		snack.setDescription(snackDto.getDescription());
		
		snack.setIngridients(snackDto.getIngridients());
		snack.set
		
	}
	
}
