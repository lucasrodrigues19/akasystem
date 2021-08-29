package br.com.akasystem.akasales.entites;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.akasales.entites.dto.AKAOrderDTO;
import br.com.akasystem.akasales.entites.dto.AKAOrderItemDTO;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAUser extends AKAMainEntity{
	
	private String id;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private List<AKAOrder> akaOrders;
	
}
