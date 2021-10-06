
package br.com.akasystem.sales.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "tbsalesevolution")
public class SalesEvolution extends SingleMainEntity{

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salesid", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_salesxsalesevolution"))
	private Sales sales;
	
	
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
		SalesEvolution other = (SalesEvolution) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
