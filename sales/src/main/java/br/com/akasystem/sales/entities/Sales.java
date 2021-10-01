
package br.com.akasystem.sales.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbsales")
public class Sales extends SingleMainEntity<UUID> {

	private static final long serialVersionUID = 1L;

	@Column(name = "price", nullable = false, columnDefinition = "numeric(10,2) default 0.0")
	private double price;
	
	@JsonIgnore
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sales")
	private Set<SalesEvolution> setSalesEvolution = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, referencedColumnName =  "id", foreignKey = @ForeignKey(name = "fk_userpjxsales"))
	private UserPejorative userPejorative;
	
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.sales")
	private Set<SalesItem> setOrderItem = new HashSet<>();
	
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
		Sales other = (Sales) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
