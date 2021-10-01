package br.com.akasystem.core.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbproduct")
@Inheritance(strategy=InheritanceType.JOINED)
public  class Product extends SingleMainEntity<UUID>{

	private static final long serialVersionUID = 1L;
	
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productId")
	private List<File> listFiles = new ArrayList<>();
	
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "id.product")
	private Set<ProductXCategory> setProductsXCategorys = new HashSet<>();;
	
	@Column(name = "price", nullable = false, columnDefinition = "numeric(10,2) default 0.0")
	private double price = 0.0;
	
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
		Product other = (Product) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
