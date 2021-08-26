package br.com.akasystem.akasales.domains;

import java.util.Set;

import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKACategory extends AKAMainEntity{

	private String id;
	
	private Set<AKAProductXCategory> akaProductXCategory;
	
	
}
