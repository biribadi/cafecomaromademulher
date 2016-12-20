package br.com.entelgy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.entelgy.models.Snack;
import br.com.entelgy.repository.IngridientRepository;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses={Snack.class})
@EnableJpaRepositories(basePackageClasses={IngridientRepository.class})
@EnableTransactionManagement
public class RepositoryConfiguration {
	
	

}
