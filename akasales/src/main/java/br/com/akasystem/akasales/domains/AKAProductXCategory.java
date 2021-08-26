package br.com.akasystem.akasales.domains;

import java.util.List;

import br.com.akasystem.akasales.domains.pk.AKAProductXCategoryPK;
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
	
	private List<AKAOrderItem> akaOrderItem;
}
