package br.com.akasystem.akasales.domains.dto;

import java.io.Serializable;

import br.com.akasystem.akasales.domains.AKAPayament;
import br.com.akasystem.core.domain.main.dto.AKAMainEntityDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AKAPayamentDTO extends AKAMainEntityDTO implements Serializable {
	
	private static final long serialVersionUID = -7349233680346996798L;

	private String id;

	public AKAPayamentDTO(AKAPayament akaPayament) {
		super(akaPayament);
		this.id = akaPayament.getId();
	}
}
