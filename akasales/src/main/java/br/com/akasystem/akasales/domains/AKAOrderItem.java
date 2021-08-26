package br.com.akasystem.akasales.domains;

import br.com.akasystem.akasales.domains.pk.AKAOrderItemPK;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAOrderItem extends AKAMainEntity{

	private AKAOrderItemPK id = new AKAOrderItemPK();
	
	private int quantity = 0;
	
	private Double price = 0.0;
}
