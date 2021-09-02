package br.com.akasystem.akasales.entitys;

import java.util.List;
import java.util.Set;

import br.com.akasystem.akasales.entites.dto.AKACategoryDTO;
import br.com.akasystem.akasales.entites.dto.AKAOrderDTO;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAProduct extends AKAMainEntity{
	
	private String id;
	
	private List<AKAOrderItem> akaOrderItems;
	
	private List<AKAOrder> akaOrders;
	
	private List<AKAFile> akaFiles;
	
	private Set<AKAProductXCategory> akaProductsXCategorys;
	
	private Set<AKACategory> akaCategorys;
	

	
	private Double price = 0.0;
	
	
}
