package br.com.entelgy.endpoint;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entelgy.model.Ingridient;
import br.com.entelgy.model.Snack;
import br.com.entelgy.repository.IngridientDao;
import br.com.entelgy.repository.SnackDAO;
import br.com.entelgy.service.IngridientService;

@RestController
@RequestMapping(path="snack")
public class SnackEndPoint {
	
	@Autowired
	private IngridientDao ingridientService;
	
	@Autowired
	private SnackDAO snackDAO;
	
	@RequestMapping(path="ingridients", method=RequestMethod.GET, produces="application/json")
	public Iterable<Ingridient> getAllAvailableIngridients(){
		
		Iterable<Ingridient> ingridients = ingridientService.findAll();
		return ingridients;
		
	}
	
	 @RequestMapping(value = "ingridients", method = RequestMethod.POST)
	 public ResponseEntity<Void> createUser(@RequestBody Ingridient ingridients,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + ingridients.getDescription());
	 
//	        if (ingridientService.isIngridientAlreadyInserted(ingridients)) {
//	            System.out.println("A User with name " + ingridients.getDescription() + " already exist");
//	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//	        }
	 
	        ingridientService.save(ingridients);
	 
	        URI resourcePath = ucBuilder.path("/ingridients/{id}").buildAndExpand(ingridients.getId()).toUri();
	        return new ResponseEntity<Void>(mountHeader(resourcePath), HttpStatus.CREATED);
	    }
	 
	 @RequestMapping(value = "snack", method = RequestMethod.GET)
	 public @ResponseBody Iterable<Snack> listSnacks( UriComponentsBuilder ucBuilder){
		 
		Iterable<Snack> snack = snackDAO.findAll();	 
		return snack;
		 
	 }
	 
	 @RequestMapping(value = "snack", method = RequestMethod.POST)
	 public ResponseEntity<Void> createUser(@Validated @RequestBody Snack snack,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Snack " + snack.getDescription());
	 
//	        if (ingridientService.isIngridientAlreadyInserted(ingridients)) {
//	            System.out.println("A User with name " + ingridients.getDescription() + " already exist");
//	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//	        }
	 
	        snackDAO.save(snack);
	 
	        URI resourcePath = ucBuilder.path("/snack/{id}").buildAndExpand(snack.getId()).toUri();
	        return new ResponseEntity<Void>(mountHeader(resourcePath), HttpStatus.CREATED);
	    }
	 
	 
	 
	 private HttpHeaders mountHeader(URI resourcePath){
		 HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(resourcePath);
	     return headers;
	 }

}
