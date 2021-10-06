package br.com.akasystem.shopping.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbproductsold")
public class ProductSold extends Product{

	private static final long serialVersionUID = 1L;
	
	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.productSold")
	private Set<OrderItem> setOrderItems = new HashSet<>();
	
	@JsonIgnore
	public Set<Order> getOrders() {
		return setOrderItems.stream().map(item -> item.getId().getOrder()).collect(Collectors.toSet());
	}
	
}
