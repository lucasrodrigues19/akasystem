package br.com.akasystem.akasales.domains;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.akasystem.akasales.domains.pk.AKAOrderItemPK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAOrderItem implements Serializable {

	private static final long serialVersionUID = -3468469729858151785L;

	private AKAOrderItemPK id = new AKAOrderItemPK();
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;
	
	private int quantity = 0;
	
	private Double price = 0.0;
}
