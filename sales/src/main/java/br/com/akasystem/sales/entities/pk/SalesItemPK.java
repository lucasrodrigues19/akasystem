package br.com.akasystem.sales.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.akasystem.sales.entities.ProductSale;
import br.com.akasystem.sales.entities.Sales;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@Embeddable
public class SalesItemPK implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productsaleid", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_saleitemxproductsale"))
	private ProductSale productSale;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salesid", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_saleitemxsales"))
	private Sales sales;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productSale == null) ? 0 : productSale.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
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
		SalesItemPK other = (SalesItemPK) obj;
		if (productSale == null) {
			if (other.productSale != null)
				return false;
		} else if (!productSale.equals(other.productSale))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		return true;
	}
}
