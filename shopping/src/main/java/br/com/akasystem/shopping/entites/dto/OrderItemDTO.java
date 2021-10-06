package br.com.akasystem.shopping.entites.dto;

import java.io.Serializable;

import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
import br.com.akasystem.shopping.entites.pk.OrderItemPK;
import br.com.akasystem.shopping.entities.OrderItem;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Setter
@NoArgsConstructor
@ToString
public class OrderItemDTO extends MainEntityDTO implements Serializable {

	private static final long serialVersionUID = -3468469729858151785L;

	private OrderItemPK id = new OrderItemPK();
	
	private int quantity = 0;
	
	private Double price = 0.0;

	public OrderItemDTO(OrderItem akaOrderItem) {
		super(akaOrderItem);
		this.quantity = akaOrderItem.getQuantity();
		this.price = akaOrderItem.getPrice();
	}
}
