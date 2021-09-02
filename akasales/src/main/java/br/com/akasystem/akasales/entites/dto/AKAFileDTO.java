package br.com.akasystem.akasales.entites.dto;

import java.io.Serializable;

import br.com.akasystem.akasales.entitys.AKAFile;
import br.com.akasystem.akasales.enums.AKAFileType;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAFileDTO extends AKAMainEntityDTO implements Serializable{ 

	private static final long serialVersionUID = -2825205901035568669L;

	private String id;
	
	private AKAFileType akaFileType;
	
	private String source;
	
	private String akaProductId;

   public AKAFileDTO(AKAFile akaFile) {
	   super(akaFile);
	   this.id = akaFile.getId();
	   this.akaFileType = akaFile.getAkaFileType();
	   this.source = akaFile.getSource();
	   this.akaProductId = akaFile.getAkaProductId();
   }
}
