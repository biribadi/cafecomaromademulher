package br.com.entelgy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.entelgy.endpoint.SnackEndPoint;
import br.com.entelgy.service.IngridientService;
import br.com.entelgy.service.IngridientServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses={ IngridientServiceImpl.class,SnackEndPoint.class})
public class Application {


	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
    
	}
	
}
