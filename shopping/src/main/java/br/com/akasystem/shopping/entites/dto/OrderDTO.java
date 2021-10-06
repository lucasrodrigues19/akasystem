package br.com.akasystem.shopping.entites.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
import br.com.akasystem.shopping.entities.Order;
import br.com.akasystem.shopping.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter	
@Setter
@NoArgsConstructor
@ToString
public class OrderDTO extends MainEntityDTO implements Serializable {
	
	private static final long serialVersionUID = -5387736056997906355L;
	
	private String idUser;
	
	private double totalValue = 0.0;
	
	private OrderStatus akaOrderStatus;
	
	private PayamentDTO akaPayamentDTO;
	
	private List<OrderItemDTO> akaOrderItemsDTO;
	
	public OrderDTO(Order akaOrder) {
		super(akaOrder);
		this.akaPayamentDTO = new PayamentDTO(akaOrder.getPayament());
		this.totalValue = akaOrder.getTotalValue();
		setDatasStructure(akaOrder);
		
	}
	
	private void setDatasStructure(Order order) {
		if(!CollectionUtils.isEmpty(order.getSetOrderItems())) {
			this.akaOrderItemsDTO = order.getSetOrderItems().stream()
					.map(aka -> new OrderItemDTO(aka))
					.collect(Collectors.toList());
		}
	}
	
}
