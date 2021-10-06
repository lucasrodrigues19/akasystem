package br.com.akasystem.core.entities.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.core.entities.Product;
import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
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
public class ProductDTO extends MainEntityDTO implements Serializable{
	
	private static final long serialVersionUID = 5698873668641210401L;

	
	private List<FileDTO> akaFilesDTO;
	
	private Set<ProductXCategoryDTO> akaProductsXCategorysDTO;
	
	private Double price = 0.0;
	
	public ProductDTO(Product akaProduct) {
		super(akaProduct);
		this.price = akaProduct.getPrice();
		setDatasStructure(akaProduct);
	}
	private void setDatasStructure(Product product) {
		
		if(!CollectionUtils.isEmpty(product.getSetProductsXCategorys())) 
			this.akaProductsXCategorysDTO = product.getSetProductsXCategorys().stream().map(aka -> new ProductXCategoryDTO(aka)).collect(Collectors.toSet());
		
		if(!CollectionUtils.isEmpty(product.getListFiles())) 
			this.akaFilesDTO = product.getListFiles().stream().map(aka -> new FileDTO(aka)).collect(Collectors.toList());
	}
}
