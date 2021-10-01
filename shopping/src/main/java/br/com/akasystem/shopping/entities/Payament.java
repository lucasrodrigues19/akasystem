package br.com.akasystem.shopping.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbpayament")
public class Payament extends SingleMainEntity<UUID> {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payament other = (Payament) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
