package br.com.akasystem.core.entities.main.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.MappedSuperclass;

import br.com.akasystem.core.entities.main.MainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class MainEntityDTO<I> {

	private I id;
	
	private String name;
	
	private LocalDateTime dtInsert;
	
	private LocalDateTime dtUpdate;
	
	private UUID idInsert;
	
	private UUID idUpdate;

	public MainEntityDTO(MainEntity<I> akaMainEntity) {
//		this.id = akaMainEntity.getId();
		this.name = akaMainEntity.getName();
		this.dtInsert = akaMainEntity.getDtInsert();
		this.dtUpdate = akaMainEntity.getDtUpdate();
		this.idInsert = akaMainEntity.getIdInsert();
		this.idUpdate = akaMainEntity.getIdUpdate();
	}
}
