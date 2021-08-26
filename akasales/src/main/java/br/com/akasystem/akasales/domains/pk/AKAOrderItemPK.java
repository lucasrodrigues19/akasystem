package br.com.akasystem.akasales.domains.pk;

import br.com.akasystem.akasales.domains.AKAOrder;
import br.com.akasystem.akasales.domains.AKAProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAOrderItemPK{

	private AKAOrder akaOrder;
	
	private AKAProduct akaProduct;
	
	
}
