package br.com.akasystem.shopping.entites.dto;

import java.io.Serializable;
import java.util.UUID;

import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
import br.com.akasystem.shopping.entities.Payament;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PayamentDTO extends MainEntityDTO<UUID> implements Serializable {
	
	private static final long serialVersionUID = -7349233680346996798L;

	public PayamentDTO(Payament akaPayament) {
		super(akaPayament);
	}
}
