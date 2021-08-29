package br.com.akasystem.core.domain.main.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.MappedSuperclass;

import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class AKAMainEntityDTO {

	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private String idInsert;
	
	private String idUpdate;

	public AKAMainEntityDTO(AKAMainEntity akaMainEntity) {
		this.name = akaMainEntity.getName();
		this.dtInsert = akaMainEntity.getDtInsert();
		this.dtUpdate = akaMainEntity.getDtUpdate();
		this.idInsert = akaMainEntity.getIdInsert();
		this.idUpdate = akaMainEntity.getIdUpdate();
	}
}
