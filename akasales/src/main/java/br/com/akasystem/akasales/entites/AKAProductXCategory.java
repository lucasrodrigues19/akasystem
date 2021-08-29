package br.com.akasystem.akasales.entites;

import br.com.akasystem.akasales.entites.pk.AKAProductXCategoryPK;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAProductXCategory extends AKAMainEntity {

	private AKAProductXCategoryPK id = new AKAProductXCategoryPK();
	
	public AKACategory getAkaCategory() {
		return this.id.getAkaCategory();
	}
	
	public void setAkaCategory (AKACategory akaCategory) {
		this.id.setAkaCategory(akaCategory);
	}
	
	public AKAProduct getAkaProduct() {
		return this.id.getAkaProduct();
	}
	
	public void setAkaProduct (AKAProduct akaProduct) {
		this.id.setAkaProduct(akaProduct);
	}
}
