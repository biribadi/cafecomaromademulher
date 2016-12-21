package br.com.entelgy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import br.com.entelgy.configuration.WebSecurityConfiguration;
import br.com.entelgy.controllers.SnackController;
import br.com.entelgy.security.controller.AuthenticationRestController;
import br.com.entelgy.secutiry.JwtAuthenticationEntryPoint;
import br.com.entelgy.services.SnackService;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
