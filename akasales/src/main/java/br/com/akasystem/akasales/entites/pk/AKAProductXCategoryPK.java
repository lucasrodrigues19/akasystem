package br.com.akasystem.akasales.entites.pk;

import br.com.akasystem.akasales.entitys.AKACategory;
import br.com.akasystem.akasales.entitys.AKAOrder;
import br.com.akasystem.akasales.entitys.AKAProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAProductXCategoryPK{

	private AKAProduct akaProduct;
	
	private AKACategory akaCategory;
	
	
}
