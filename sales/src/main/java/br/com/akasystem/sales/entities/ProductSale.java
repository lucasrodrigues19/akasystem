package br.com.akasystem.sales.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@Entity
@Table(name = "tbproductsale")
public class ProductSale extends Product{

	private static final long serialVersionUID = 1L;
	
	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.productSale")
	private Set<SalesItem> setOrderItem = new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name=  "fk_userpjxproductsale"))
	private UserPejorative userPejorative;
	
	
	@JsonIgnore
	public Set<Sales> getSales() {
		return this.setOrderItem.stream().map(item -> item.getSales()).collect(Collectors.toSet());
	}
}
