package br.com.akasystem.sales.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.akasystem.core.repositorys.main.MainRepository;
import br.com.akasystem.sales.entities.UserPejorative;

public interface UserPejorativeRepository extends MainRepository<UserPejorative, UUID> {

	
	@Modifying
	@Query(value = "insert into tbuserpejorative (id, cnpj) values (:id, :cnpj)",nativeQuery = true)
	void insert(@Param("id") String id, @Param("cnpj") String cnpj);
}
