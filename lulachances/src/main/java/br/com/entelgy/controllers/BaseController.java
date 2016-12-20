package br.com.entelgy.controllers;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1")
public class BaseController {
	
	public HttpHeaders mountHeader(URI resourcePath) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(resourcePath);
		return headers;
	}
	
	

}
