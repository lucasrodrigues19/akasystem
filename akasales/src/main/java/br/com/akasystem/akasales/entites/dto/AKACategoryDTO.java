package br.com.akasystem.akasales.entites.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.akasales.entites.AKACategory;
import br.com.akasystem.akasales.entites.AKAProduct;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AKACategoryDTO extends AKAMainEntityDTO implements Serializable{
	
	private static final long serialVersionUID = 5698873668641210401L;

	private String id;
	
	private Set<AKAProductXCategoryDTO> akaProductsXCategorysDTO;
	
	private Set<AKAProductDTO> akaProductsDTO;
	
	public AKACategoryDTO(AKACategory akaCategory) {
		super(akaCategory);
		this.id = akaCategory.getId();
		setDatasStructure(akaCategory);
	}
	
	private void setDatasStructure(AKACategory akaCategory) {
		if(!CollectionUtils.isEmpty(akaCategory.getAkaProductsXCategorys())) 
			this.akaProductsXCategorysDTO = akaCategory.getAkaProductsXCategorys().stream().map(aka -> new AKAProductXCategoryDTO(aka)).collect(Collectors.toSet());
		
		if(!CollectionUtils.isEmpty(akaCategory.getAkaProducts())) 
			this.akaProductsDTO = akaCategory.getAkaProducts().stream().map(aka -> new AKAProductDTO(aka)).collect(Collectors.toSet());
	}
}
