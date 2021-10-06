package br.com.akasystem.input;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"br.com.akasystem.core.entities.main","br.com.akasystem.core.entities", "br.com.akasystem.sales.entities","br.com.akasystem.shopping.entities"})
@ComponentScan({"br.com.akasystem.core","br.com.akasystem.sales","br.com.akasystem.shopping","br.com.akasystem.input"})
@EnableJpaRepositories({"br.com.akasystem.core.repository.main","br.com.akasystem.core.repository"})
@EnableAutoConfiguration
public class InputApplication {

	public static void main(String[] args) {
		SpringApplication.run(InputApplication.class, args);
	}

}
