package br.com.akasystem.shopping.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tborder")
public class Order extends SingleMainEntity<UUID> implements Comparable<Order>, Serializable{
	
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "payamentid", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_orderxpayament01"))
	private Payament payament;
	
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "id.order", fetch = FetchType.LAZY)
	private Set<OrderItem> setOrderItems = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY) //Associação de mão dupla
	@JoinColumn(name = "userid", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_orderxuser01"))
	private UserPhysical user;
	 
	@Setter(AccessLevel.NONE)
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private Set<OrderEvolution> setOrderEvolution = new HashSet<>();
	
	public double getTotalValue() {
		if(!CollectionUtils.isEmpty(this.setOrderItems))
			return  this.setOrderItems.stream().mapToDouble(oi -> oi.getQuantity() * oi.getPrice()).sum();
		return 0.0;
	}
	
	@Override
	public int compareTo(Order o) {
		if(o.getId().equals(this.getId()))
			return 1;
		return 0;
	}

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
		Order other = (Order) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
	
	
	
	
}
