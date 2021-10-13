package br.com.akasystem.core.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akasystem.core.entities.Roles;
import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.repositorys.RolesRepository;
import br.com.akasystem.core.repositorys.UserRepository;
import br.com.akasystem.core.services.main.MainService;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/06
 */
@Service
public class RolesService extends MainService<Roles, UUID>{
	
	
	private  RolesRepository rolesRepository;
	
	@Autowired
	public RolesService(RolesRepository rolesRepository) {
		setRepository(rolesRepository);
		this.rolesRepository = rolesRepository;
	}
	
	
	
}
