package br.com.akasystem.core.repository;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.repository.main.MainRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Transactional
public interface UserRepository extends MainRepository<User, UUID>,JpaSpecificationExecutor<User> {

}
