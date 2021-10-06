package br.com.akasystem.core.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbcategory")
public class Category extends SingleMainEntity implements Comparable<Category>, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.category")
	private Set<ProductXCategory> setProductsXCategorys = new HashSet<>();

	@JsonIgnore
	public Set<Product> getProducts(){
		return this.setProductsXCategorys.stream().map(x -> x.getId().getProduct()).collect(Collectors.toSet());
	}
	
	@Override
	public int compareTo(Category o) {
		if(o.getId().equals(this.getId()))
			return 1;
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		Category other = (Category) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
	
	
	
	
}
