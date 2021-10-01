package br.com.akasystem.shopping.entites.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.akasystem.core.entities.Product;
import br.com.akasystem.shopping.entities.Order;
import br.com.akasystem.shopping.entities.ProductSold;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class OrderItemPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "orderid",nullable = false, foreignKey = @ForeignKey(name = "fk_orderitemxorder"))//tentar mudar a foregin key
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "productid",nullable = false, foreignKey = @ForeignKey(name = "fk_orderitemxproductsold"))
	private ProductSold productSold;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((productSold == null) ? 0 : productSold.hashCode());
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
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (productSold == null) {
			if (other.productSold != null)
				return false;
		} else if (!productSold.equals(other.productSold))
			return false;
		return true;
	}

	
	
	
}
