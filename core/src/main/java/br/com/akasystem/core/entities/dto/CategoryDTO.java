package br.com.akasystem.core.entities.dto;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.core.entities.Category;
import br.com.akasystem.core.entities.Product;
import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CategoryDTO extends MainEntityDTO implements Serializable{
	
	private static final long serialVersionUID = 5698873668641210401L;

	
	@Setter(AccessLevel.NONE)
	private Set<ProductDTO> setProducts;
	
	public CategoryDTO(Category akaCategory) {
		super(akaCategory);
		setDatasStructure(akaCategory);
	}
	
	private void setDatasStructure(Category category) {
		if(!CollectionUtils.isEmpty(category.getProducts())) 
			this.setProducts = category.getProducts().stream().map(aka -> new ProductDTO(aka)).collect(Collectors.toSet());
		
	}
}
