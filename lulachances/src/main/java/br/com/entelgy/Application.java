package br.com.entelgy;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.entelgy.controllers.SnackController;
import br.com.entelgy.services.IngridientService;
import br.com.entelgy.services.IngridientServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses={ IngridientServiceImpl.class,SnackController.class})
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
