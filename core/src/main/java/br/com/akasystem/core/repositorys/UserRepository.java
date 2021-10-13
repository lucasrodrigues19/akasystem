package br.com.akasystem.core.repositorys;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.repositorys.main.MainRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Transactional
public interface UserRepository extends MainRepository<User, UUID>,JpaSpecificationExecutor<User> {

}
