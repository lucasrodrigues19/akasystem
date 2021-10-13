package br.com.akasystem.core.repositorys;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.akasystem.core.entities.ProductXCategory;
import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.entities.pk.ProductXCategoryPK;
import br.com.akasystem.core.repositorys.main.MainRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Repository
public interface ProductXCategoryRepository extends MainRepository<ProductXCategory, ProductXCategoryPK>{

}
