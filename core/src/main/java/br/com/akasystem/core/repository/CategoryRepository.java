package br.com.akasystem.core.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.akasystem.core.entities.Category;
import br.com.akasystem.core.repository.main.MainRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Repository
public interface CategoryRepository extends MainRepository<Category,UUID>{

}
