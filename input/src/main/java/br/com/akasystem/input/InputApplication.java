package br.com.akasystem.input;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"br.com.akasystem.core.entities.main","br.com.akasystem.core.entities", "br.com.akasystem.sales.entities","br.com.akasystem.shopping.entities"})
@ComponentScan({"br.com.akasystem.core","br.com.akasystem.sales","br.com.akasystem.shopping"})
@EnableAutoConfiguration
public class InputApplication {

	public static void main(String[] args) {
		SpringApplication.run(InputApplication.class, args);
	}

}
