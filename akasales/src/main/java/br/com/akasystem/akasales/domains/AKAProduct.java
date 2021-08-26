package br.com.akasystem.akasales.domains;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAProduct implements Serializable{
	
	private static final long serialVersionUID = 5698873668641210401L;

	private String id;
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;
	
	private List<AKAOrderItem> akaOrderItem;
	
	private Set<AKAProductXCategory> akaProductXCategory;
	
	private Double price = 0.0;
	
	
}
