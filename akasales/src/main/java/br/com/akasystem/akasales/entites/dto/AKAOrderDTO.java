package br.com.akasystem.akasales.entites.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.akasales.entitys.AKAOrder;
import br.com.akasystem.akasales.enums.AKAOrderStatus;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter	
@Setter
@NoArgsConstructor
@ToString
public class AKAOrderDTO extends AKAMainEntityDTO implements Serializable {
	
	private static final long serialVersionUID = -5387736056997906355L;
	
	private String id;
	
	private String idUser;
	
	private double totalValue = 0.0;
	
	private AKAOrderStatus akaOrderStatus;
	
	private AKAPayamentDTO akaPayamentDTO;
	
	private List<AKAOrderItemDTO> akaOrderItemsDTO;
	
	public AKAOrderDTO(AKAOrder akaOrder) {
		super(akaOrder);
		this.id = akaOrder.getId();
		this.akaOrderStatus = akaOrder.getAkaOrderStatus();
		this.akaPayamentDTO = new AKAPayamentDTO(akaOrder.getAkaPayament());
		this.totalValue = akaOrder.getTotalValue();
		setDatasStructure(akaOrder);
		
	}
	
	private void setDatasStructure(AKAOrder akaOrder) {
		if(!CollectionUtils.isEmpty(akaOrder.getAkaOrderItems())) {
			this.akaOrderItemsDTO = akaOrder.getAkaOrderItems().stream()
					.map(aka -> new AKAOrderItemDTO(aka))
					.collect(Collectors.toList());
		}
	}
	
}
