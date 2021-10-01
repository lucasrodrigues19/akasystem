package br.com.akasystem.core.entities.dto;

import java.io.Serializable;
import java.util.UUID;

import br.com.akasystem.core.entities.ProductXCategory;
import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProductXCategoryDTO extends MainEntityDTO<UUID> implements Serializable {
	
	private static final long serialVersionUID = 7457639335310969255L;

	public ProductXCategoryDTO(ProductXCategory akaProductXCategory) {
		super(akaProductXCategory);
	}
}
