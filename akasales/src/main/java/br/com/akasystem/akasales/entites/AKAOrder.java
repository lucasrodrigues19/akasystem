package br.com.akasystem.akasales.entites;

import java.util.List;

import br.com.akasystem.akasales.enums.AKAOrderStatus;
import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAOrder extends AKAMainEntity implements Comparable<AKAOrder>{
	
	private String id;
	
	private String idUser;
	
	private AKAOrderStatus akaOrderStatus;
	
	private AKAPayament akaPayament;
	
	private List<AKAOrderItem> akaOrderItems;
	
	private List<AKAProduct> akaProducts;

	
	@Override
	public int compareTo(AKAOrder o) {
		if(o.getId().equals(this.id))
			return 1;
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AKAOrder other = (AKAOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
}
