package br.com.akasystem.akasales.entitys;

import br.com.akasystem.akasales.entites.pk.AKAOrderItemPK;
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

	public AKAOrder getAkaOrder() {
		return this.id.getAkaOrder();
	}
	
	public void setAkaOrder (AKAOrder akaOrder) {
		this.id.setAkaOrder(akaOrder);
	}
	
	public AKAProduct getAkaProduct() {
		return this.id.getAkaProduct();
	}
	
	public void setAkaProduct (AKAProduct akaProduct) {
		this.id.setAkaProduct(akaProduct);
	}
}

