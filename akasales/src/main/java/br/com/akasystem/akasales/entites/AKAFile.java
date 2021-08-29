package br.com.akasystem.akasales.entites;

import br.com.akasystem.akasales.enums.AKAFileType;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAFile extends AKAMainEntity{
	
	private String id;
	
	private AKAFileType akaFileType;
	
	private String source;
	
	private String akaproductid;
}
