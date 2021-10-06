package br.com.akasystem.core.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.repository.UserRepository;
import br.com.akasystem.core.services.main.MainService;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Service
public class UserService extends MainService<User, UUID>{
	
	
	private  UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		setRepository(userRepository);
		this.userRepository = userRepository;
	}
	
}
