package br.com.entelgy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.entelgy.controllers.SnackController;
import br.com.entelgy.models.UserSnacks;
import br.com.entelgy.repository.UserRepository;
import br.com.entelgy.services.SnackService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { SnackController.class, SnackService.class })
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
	
	@Configuration
	class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	  @Autowired
	  UserRepository accountRepository;

	  @Override
	  public void init(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService());
	  }

	  @Bean
	  UserDetailsService userDetailsService() {
	    return new UserDetailsService() {

	      @Override
	      public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        UserSnacks user = accountRepository.findAllUserByEmail(email).get(0);
	        if(user != null) {
	        return new org.springframework.security.core.userdetails.User(email, 
	        		user.getPassword(), true, true, true, true,
	               user.getAuthorities());
	        } else {
	          throw new UsernameNotFoundException("could not find the user '"
	                  + email + "'");
	        }
	      }
	      
	    };
	  }
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests().anyRequest().fullyAuthenticated().and().
	    httpBasic().and().
	    csrf().disable();
	  }
	  
	}
	
}
