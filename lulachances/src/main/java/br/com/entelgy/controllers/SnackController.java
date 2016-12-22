package br.com.entelgy.controllers;

import static br.com.entelgy.utils.DtoHelper.*;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entelgy.dtos.SnackDto;
import br.com.entelgy.models.Snack;
import br.com.entelgy.services.SnackService;

@RestController
@RequestMapping(value="v1")
public class SnackController {

	@Autowired
	private SnackService snackService;
	
	@RequestMapping(path="snack", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SnackDto>> listSnacks() {

		List<Snack> snacks = snackService.findAll();
		List<SnackDto> dtos = snacks.stream().map(snack -> convertToSnackDto(snack)).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@RequestMapping(path="snack" , method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSnack(@Validated @RequestBody SnackDto snackDto, UriComponentsBuilder ucBuilder) throws ParseException{
		
		Snack snack = convertToSnackEntity(snackDto);
		
		snackService.save(snack);

		URI resourcePath = ucBuilder.path("/snacks/{id}").buildAndExpand(snack.getId()).toUri();
		return ResponseEntity.created(resourcePath).build();
	}
}
