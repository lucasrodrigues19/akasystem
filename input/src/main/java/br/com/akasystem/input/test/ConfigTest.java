package br.com.akasystem.input.test;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.enums.Status;
import br.com.akasystem.core.repository.UserRepository;
import br.com.akasystem.core.services.UserService;

/**
 * Classe de configuração para teste, valida somente para o perfil test
 * @author Lucas Rodrigues
 * @since 2021/08/28
 */
@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		UUID id = UUID.randomUUID();
		User user =  new User();
		user.setId(id);
		user.setDtInsert(LocalDateTime.now());
		user.setDtUpdate(LocalDateTime.now());
		user.setIdInsert(id);
		user.setIdUpdate(id);
		user.setName("aka-system");
		user.setEmail("aka-system@aka.com.br");
		user.setPassword("1234");
		user.setPhone("1100000000");
		user.setStatus(Status.ACTIVE);
		userService.saveOrUpdate(user);
	}
	
}