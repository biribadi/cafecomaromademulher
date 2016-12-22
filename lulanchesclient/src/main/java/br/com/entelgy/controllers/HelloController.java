package br.com.entelgy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value = "hello")
	public String hello(Model model){
		//Busca por default templates dentro da pasta ../resources/templates -> extensão default html
		//aqui nao retorna ModelAndView, mas sim uma string pra view mesmo
		//Esse model é o "modelAndView"
		
		model.addAttribute("key", "Usando ModelAndView diferentao do SpringBoot");
		
		return "hello";
	}

}
