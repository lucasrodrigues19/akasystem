package br.com.akasystem.akasales.domains.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AKAProductDTO implements Serializable{
	
	private static final long serialVersionUID = 5698873668641210401L;

	private String id;
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;
	
	private List<AKAOrderItemDTO> akaOrderItemDTO;
	
	private Set<AKAProductXCategoryDTO> akaProductXCategoryDTO;
	
	private Set<AKACategoryDTO> akaCategoryDTO;
	
	private List<AKAOrderDTO> akaOrderDTO;
	
	private Double price = 0.0;
	
	
}
