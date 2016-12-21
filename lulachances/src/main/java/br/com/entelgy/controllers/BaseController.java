package br.com.entelgy.controllers;

import java.net.URI;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.ServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entelgy.dtos.IngridientDto;
import br.com.entelgy.dtos.SnackDto;
import br.com.entelgy.models.Ingridient;
import br.com.entelgy.models.Snack;

@RestController
public class BaseController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ServletRequest servletRequest;

	public HttpHeaders mountHeader(URI resourcePath) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(resourcePath);
		return headers;
	}

	public IngridientDto convertToIngridientDto(Ingridient ingridient) {
		IngridientDto ingridientDto = modelMapper.map(ingridient, IngridientDto.class);
		if (servletRequest.getLocale().getLanguage().equals(Locale.ENGLISH.getLanguage())) {
			ingridientDto.setDescription(ingridient.getDescription().getWordEnUs());
			ingridientDto.getIngridientType().setTypeTranslated(ingridient.getIngridientType().getType().getWordEnUs());
		} else {
			ingridientDto.setDescription(ingridient.getDescription().getWordPtBr());
			ingridientDto.getIngridientType().setTypeTranslated(ingridient.getIngridientType().getType().getWordPtBr());
		}

		return ingridientDto;
	}

	public SnackDto convertToSnackDto(Snack snack) {
		SnackDto snackDto = modelMapper.map(snack, SnackDto.class);
		return snackDto;
	}

	public Snack convertToSnackEntity(SnackDto snackDto) throws ParseException {
		Snack snack = modelMapper.map(snackDto, Snack.class);
		// if (postDto.getId() != null) {
		// Post oldPost = postService.getPostById(postDto.getId());
		// post.setRedditID(oldPost.getRedditID());
		// post.setSent(oldPost.isSent());
		// }
		return snack;
	}

}
