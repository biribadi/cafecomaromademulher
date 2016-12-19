package br.com.entelgy.controllers;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entelgy.dtos.SnackDto;
import br.com.entelgy.models.Snack;
import br.com.entelgy.repository.SnackDAO;

@RestController
@RequestMapping(path = "snack")
public class SnackController {

	@Autowired
	private SnackDAO snackDAO;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "snack", method = RequestMethod.GET)
	public @ResponseBody List<SnackDto> listSnacks() {

		List<Snack> snacks = (List<Snack>) snackDAO.findAll();
		return snacks.stream().map(snack -> convertToDto(snack)).collect(Collectors.toList());

	}

	@RequestMapping(value = "snack", method = RequestMethod.POST)
	public ResponseEntity<Void> createSnack(@Validated @RequestBody SnackDto snackDto, UriComponentsBuilder ucBuilder) throws ParseException{
		System.out.println("Creating Snack " + snackDto.getDescription());
		
		Snack snack = convertToEntity(snackDto);
		
		snackDAO.save(snack);

		URI resourcePath = ucBuilder.path("/snack/{id}").buildAndExpand(snack.getId()).toUri();
		return new ResponseEntity<Void>(mountHeader(resourcePath), HttpStatus.CREATED);
	}

	private HttpHeaders mountHeader(URI resourcePath) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(resourcePath);
		return headers;
	}
	
	private SnackDto convertToDto(Snack snack) {
	    SnackDto snackDto = modelMapper.map(snack, SnackDto.class);
	    return snackDto;
	}
	
	private Snack convertToEntity(SnackDto snackDto) throws ParseException {
		Snack snack = modelMapper.map(snackDto, SnackDto.class);
//	    if (postDto.getId() != null) {
//	        Post oldPost = postService.getPostById(postDto.getId());
//	        post.setRedditID(oldPost.getRedditID());
//	        post.setSent(oldPost.isSent());
//	    }
	    return snack;
	}

}
