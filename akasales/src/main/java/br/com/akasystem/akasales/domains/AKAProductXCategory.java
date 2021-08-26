package br.com.akasystem.akasales.domains;

import java.time.LocalDateTime;
import java.util.List;

import br.com.akasystem.akasales.domains.pk.AKAProductXCategoryPK;

public class AKAProductXCategory {

	private AKAProductXCategoryPK id = new AKAProductXCategoryPK();
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;
	
	private List<AKAOrderItem> akaOrderItem;
}
