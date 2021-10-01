package br.com.akasystem.core.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.akasystem.core.entities.main.MainEntity;

public interface MainRepository<T extends MainEntity<I>,I> extends JpaRepository<T, I>{

	@Modifying
	@Query("update T t set t.statusactive = :statusActive where t.id = :id")
	void updateEntity(@Param(value="statusActive") int statusActive, @Param(value="id") I id);
}
