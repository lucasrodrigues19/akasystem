package br.com.akasystem.akasales.entites.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.akasystem.akasales.entites.AKAUser;
import br.com.akasystem.akasales.enums.AKAOrderStatus;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AKAUserDTO extends AKAMainEntityDTO implements Serializable {
	
	private static final long serialVersionUID = -5387736056997906355L;

	private String id;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	List<AKAOrderDTO> akaOrderDTOs;
	
	public AKAUserDTO(AKAUser akaUser) {
		super(akaUser);
		this.id = akaUser.getId();
		this.email = akaUser.getEmail();
		this.phone = akaUser.getPhone();
		this.password = akaUser.getPassword();
	}
	
	public void setDatasStructure(AKAUser akaUser) {
		if(!CollectionUtils.isEmpty(akaUser.getAkaOrders())) 
			this.akaOrderDTOs = akaUser.getAkaOrders().stream().map(aka -> new AKAOrderDTO(aka)).collect(Collectors.toList());
	}
	
}
