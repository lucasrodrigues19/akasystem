package br.com.akasystem.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akasystem.core.entities.Privilege;
import br.com.akasystem.core.entities.pk.PrivilegePK;
import br.com.akasystem.core.repositorys.PrivilegeRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/06
 */
@Service
public class PrivilegeService{
	
	@Autowired
	private  PrivilegeRepository privilegeRepository;
	
	
	public Privilege save(Privilege entity){
		return privilegeRepository.save(entity);
	}
	
	public Privilege findById(PrivilegePK id) {
		return privilegeRepository.findById(id).orElse(new Privilege());
	}
	
	public List<Privilege> saveAll(List<Privilege> list){
		return privilegeRepository.saveAll(list);
	}
}
