package br.com.akasystem.akasales.domains;

import java.util.List;

import br.com.akasystem.akasales.enums.AKAOrderStatus;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAOrder extends AKAMainEntity{
	
	private String id;
	
	private String idUser;
	
	private AKAOrderStatus akaOrderStatus;
	
	private AKAPayament akaPayament;
	
	private List<AKAOrderItem> akaOrderItem;
	
	
	
	
	
}
