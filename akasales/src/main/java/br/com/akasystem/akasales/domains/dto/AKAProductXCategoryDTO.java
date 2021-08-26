package br.com.akasystem.akasales.domains.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import br.com.akasystem.akasales.domains.pk.AKAProductXCategoryPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AKAProductXCategoryDTO {

	private AKAProductXCategoryPK id = new AKAProductXCategoryPK();
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;
	
}
