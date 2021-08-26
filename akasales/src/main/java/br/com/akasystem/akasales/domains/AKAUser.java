package br.com.akasystem.akasales.domains;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.akasystem.akasales.enums.AKAOrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAUser implements Serializable {
	
	private static final long serialVersionUID = -5387736056997906355L;

	private String id;
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;
	
	private String idUser;
	
	private AKAOrderStatus akaOrderStatus;
	
	private AKAPayament akaPayament;
	
	private List<AKAOrderItem> akaOrderItem;
	
	
	
	
}
