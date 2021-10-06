package br.com.akasystem.shopping.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.Product;
import br.com.akasystem.core.entities.main.MainEntity;
import br.com.akasystem.shopping.entites.pk.OrderItemPK;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tborderitem")
public class OrderItem extends MainEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Setter(AccessLevel.NONE)
	@EmbeddedId
	private OrderItemPK id =  new OrderItemPK();
	
	@Column(name = "quantity", nullable = false, columnDefinition = "numeric (1) default 0")
	private int quantity = 0;
	
	@Column(name = "price", nullable = false, columnDefinition = "numeric(10,2) default 0.0")
	private double price = 0.0;

	@JsonIgnore
	public Order getOrder() {
		return this.id.getOrder();
	}
	
	public void setOrder (Order order) {
		this.id.setOrder(order);
	}
	
	public Product getProductSold() {
		return this.id.getProductSold();
	}
	
	public void setProduct (ProductSold productSold) {
		this.id.setProductSold(productSold);
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
		OrderItem other = (OrderItem) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}

