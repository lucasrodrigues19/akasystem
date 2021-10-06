package br.com.akasystem.core.entities.dto;

import java.io.Serializable;
import java.util.UUID;

import br.com.akasystem.core.entities.File;
import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
import br.com.akasystem.core.enums.FileType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FileDTO extends MainEntityDTO implements Serializable{ 

	private static final long serialVersionUID = -2825205901035568669L;

	private FileType akaFileType;
	
	private byte[] source;
	
	private String akaProductId;

   public FileDTO(File akaFile) {
	   super(akaFile);
	   this.akaFileType = akaFile.getFileType();
	   this.source = akaFile.getSource();
	   this.akaProductId = akaFile.getProductId();
   }
}
