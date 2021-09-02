package br.com.akasystem.akasales.entites.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.akasales.entitys.AKAOrder;
import br.com.akasystem.akasales.entitys.AKAProduct;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AKAProductDTO extends AKAMainEntityDTO implements Serializable{
	
	private static final long serialVersionUID = 5698873668641210401L;

	private String id;
	
	private List<AKAOrderItemDTO> akaOrderItemsDTO;
	
	private List<AKAFileDTO> akaFilesDTO;
	
	private Set<AKAProductXCategoryDTO> akaProductsXCategorysDTO;
	
	private Double price = 0.0;
	
	public AKAProductDTO(AKAProduct akaProduct) {
		super(akaProduct);
		this.id = akaProduct.getId();
		this.price = akaProduct.getPrice();
		setDatasStructure(akaProduct);
	}
	private void setDatasStructure(AKAProduct akaProduct) {
		
		if(!CollectionUtils.isEmpty(akaProduct.getAkaOrderItems()))
			this.akaOrderItemsDTO = akaProduct.getAkaOrderItems().stream().map(aka -> new AKAOrderItemDTO(aka)).collect(Collectors.toList());
		
		if(!CollectionUtils.isEmpty(akaProduct.getAkaProductsXCategorys())) 
			this.akaProductsXCategorysDTO = akaProduct.getAkaProductsXCategorys().stream().map(aka -> new AKAProductXCategoryDTO(aka)).collect(Collectors.toSet());
		
		if(!CollectionUtils.isEmpty(akaProduct.getAkaFiles())) 
			this.akaFilesDTO = akaProduct.getAkaFiles().stream().map(aka -> new AKAFileDTO(aka)).collect(Collectors.toList());
	}
}
