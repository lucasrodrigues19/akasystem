package br.com.akasystem.akasales.entites.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import br.com.akasystem.akasales.entites.pk.AKAProductXCategoryPK;
import br.com.akasystem.akasales.entitys.AKAProductXCategory;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AKAProductXCategoryDTO extends AKAMainEntityDTO implements Serializable {
	
	private static final long serialVersionUID = 7457639335310969255L;

	private AKAProductXCategoryPK id = new AKAProductXCategoryPK();
	
	public AKAProductXCategoryDTO(AKAProductXCategory akaProductXCategory) {
		super(akaProductXCategory);
		this.id = akaProductXCategory.getId();
	}
}
