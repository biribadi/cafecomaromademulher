package br.com.entelgy.controllers;

import static br.com.entelgy.utils.DtoHelper.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.entelgy.dtos.IngridientDto;
import br.com.entelgy.models.Ingridient;
import br.com.entelgy.services.IngridientService;

@RestController
@RequestMapping(value = "v1")
public class IngridientController{
	
	@Autowired
	private IngridientService ingridientService;
	
	@RequestMapping(path = "ingridient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listIngridients() {
		
		List<Ingridient> ingridients = (List<Ingridient>) ingridientService.findAll();
		if (ingridients == null || ingridients.size() <= 0){
			return  ResponseEntity.notFound().build();
		}
		List<IngridientDto> dtos = ingridients.stream().map(ingridient -> convertToIngridientDto(ingridient)).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}


}
