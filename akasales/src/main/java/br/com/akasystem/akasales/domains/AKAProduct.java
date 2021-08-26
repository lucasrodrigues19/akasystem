package br.com.akasystem.akasales.domains;

import java.util.List;
import java.util.Set;

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
	
	private List<AKAOrderItem> akaOrderItem;
	
	private Set<AKAProductXCategory> akaProductXCategory;
	
	private Double price = 0.0;
	
	
}
