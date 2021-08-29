package br.com.akasystem.akasales.domains.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.akasystem.akasales.domains.AKAOrderItem;
import br.com.akasystem.akasales.domains.pk.AKAOrderItemPK;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAOrderItemDTO extends AKAMainEntityDTO implements Serializable {

	private static final long serialVersionUID = -3468469729858151785L;

	private AKAOrderItemPK id = new AKAOrderItemPK();
	
	private int quantity = 0;
	
	private Double price = 0.0;

	public AKAOrderItemDTO(AKAOrderItem akaOrderItem) {
		super(akaOrderItem);
		this.id = akaOrderItem.getId();
		this.quantity = akaOrderItem.getQuantity();
		this.price = akaOrderItem.getPrice();
	}
}
