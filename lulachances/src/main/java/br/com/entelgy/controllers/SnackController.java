package br.com.entelgy.controllers;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.ServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entelgy.dtos.IngridientDto;
import br.com.entelgy.dtos.SnackDto;
import br.com.entelgy.models.Ingridient;
import br.com.entelgy.models.Snack;
import br.com.entelgy.services.IngridientService;
import br.com.entelgy.services.SnackService;

@RestController
@RequestMapping(value="snack")
public class SnackController extends BaseController{

	@Autowired
	private IngridientService ingridientService;

	@Autowired
	private SnackService snackService;
	
	@RequestMapping(path = "ingridients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IngridientDto>> listIngridients() {
		
		List<Ingridient> ingridients = (List<Ingridient>) ingridientService.findAll();
		if (ingridients == null){
			return new ResponseEntity<List<IngridientDto>>(HttpStatus.NO_CONTENT);
		}
		List<IngridientDto> dtos = ingridients.stream().map(ingridient -> convertToIngridientDto(ingridient)).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@RequestMapping( method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<SnackDto>> listSnacks() {

		List<Snack> snacks = snackService.findAll();
		List<SnackDto> dtos = snacks.stream().map(snack -> convertToSnackDto(snack)).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSnack(@Validated @RequestBody SnackDto snackDto, UriComponentsBuilder ucBuilder) throws ParseException{
		System.out.println("Creating Snack " + snackDto.getDescription());
		
		Snack snack = convertToSnackEntity(snackDto);
		
		snackService.save(snack);

		URI resourcePath = ucBuilder.path("/snacks/{id}").buildAndExpand(snack.getId()).toUri();
		return ResponseEntity.created(resourcePath).build();
	}
	
//	@RequestMapping(value = "ingridients", method = RequestMethod.POST, consumes="application/json")
//	public ResponseEntity<Void> createIngridient(@Validated @RequestBody IngridientDto ingridientDto, UriComponentsBuilder ucBuilder) throws ParseException {
//		System.out.println("Creating Ingridient " + ingridientDto.getDescription());
//		
//		Ingridient ingridient = convertToIngridientEntity(ingridientDto);
//		
//		ingridientDAO.save(ingridient);
//		
//		URI resourcePath = ucBuilder.path("/snack/ingridient/{id}").buildAndExpand(ingridient.getId()).toUri();
//		return new ResponseEntity<Void>(mountHeader(resourcePath), HttpStatus.CREATED);
//	}
	
//	@RequestMapping(path = "ingridients/{id}", method = RequestMethod.GET, produces="application/json")
//	public ResponseEntity<Ingridient> findOne(@PathVariable("id") Integer id) {
//	    Ingridient ingridient =  ingridientService.(id);
//	    if (ingridient == null){
//	    	return new ResponseEntity<Ingridient>(HttpStatus.NO_CONTENT);
//	    }
//	    return new ResponseEntity<Ingridient>(ingridient, HttpStatus.OK);
//	}

	
	
//	private Ingridient convertToIngridientEntity(IngridientDto ingridientDto) throws ParseException {
//		Ingridient ingridient = modelMapper.map(ingridientDto, Ingridient.class);
//	    return ingridient;
//	}

}
