package br.com.akasystem.core.repository.main;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import br.com.akasystem.core.entities.main.MainEntity;
import br.com.akasystem.core.enums.Status;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@NoRepositoryBean
public interface MainRepository<T extends MainEntity,I> extends JpaRepository<T, UUID>{

	@Modifying
	@Query(nativeQuery = true, value = "update #{#entityName} set #{#entityName}.statusActive=:#{#statusActive.INT} where #{#entityName}.id = :id")
	void updateEntity(@Param(value="statusActive") Status statusActive, @Param(value="id") UUID id);
}
