package br.com.akasystem.core.repository;

import org.springframework.stereotype.Repository;

import br.com.akasystem.core.entities.Privilege;
import br.com.akasystem.core.entities.pk.PrivilegePK;
import br.com.akasystem.core.repository.main.MainRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Repository
public interface PrivilegeRepository extends MainRepository<Privilege, PrivilegePK>{

}
