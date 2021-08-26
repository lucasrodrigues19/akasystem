package br.com.akasystem.akasales.domains.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.akasystem.akasales.enums.AKAOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AKAOrderDTO implements Serializable {
	
	private static final long serialVersionUID = -5387736056997906355L;

	private String id;
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;
	
	private String idUser;
	
	private AKAOrderStatus akaOrderStatus;
	
	private AKAPayamentDTO akaPayamentDTO;
	
	private List<AKAOrderItemDTO> akaOrderItemDTO;
	
	private List<AKAProductDTO> AKAProductDTO;
	
	
}
