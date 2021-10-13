package br.com.akasystem.sales.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akasystem.core.services.UserService;
import br.com.akasystem.core.services.main.MainService;
import br.com.akasystem.sales.entities.UserPejorative;
import br.com.akasystem.sales.repositorys.UserPejorativeRepository;

@Service
public class UserPejorativeService extends MainService<UserPejorative, UUID> {

	
	
	@Autowired
	private UserPejorativeRepository userPejorativeRepository;
	
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	public UserPejorativeService(UserPejorativeRepository userPejorativeRepository) {
		setRepository(userPejorativeRepository);
	}
	
	@Transactional
	@Override
	public UserPejorative saveOrUpdate(UserPejorative entity) {
		if(entity.getId() != null) {
			
			if(userPejorativeRepository == null)
				throw new RuntimeException("Não existe repositorio criado... "+entity.getClass().getName());
			
			if(userService.findById(entity.getId()) == null)
				throw new RuntimeException("Usuario pai inexistente");
			
			Optional<UserPejorative> optionalEntityExisting = userPejorativeRepository.findById(entity.getId());
			UserPejorative entityExisting = optionalEntityExisting.orElse(null);
			
			if(entityExisting != null)
				super.margeEntity(entityExisting, entity);
		}
		userPejorativeRepository.insert(entity.getId().toString(), entity.getCnpj().replaceAll("[^a-zA-Z0-9]", ""));
		return entity;
	}
	
	
}
