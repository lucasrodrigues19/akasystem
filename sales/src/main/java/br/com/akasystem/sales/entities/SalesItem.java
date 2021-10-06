package br.com.akasystem.sales.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.main.MainEntity;
import br.com.akasystem.sales.entities.pk.SalesItemPK;
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
@Table(name = "tbsalesitem")
public class SalesItem extends MainEntity{


	@Setter(AccessLevel.NONE)
	@EmbeddedId
	private SalesItemPK id = new SalesItemPK();
	
	@Column(name = "quantity", nullable = false, columnDefinition = "numeric (1) default 0")
	private int quantity = 0;
	
	@Column(name = "price", nullable = false, columnDefinition = "numeric(10,2) default 0.0")
	private double price = 0.0;
	
	public ProductSale getProductSale() {
		return this.id.getProductSale();
	}
	
	public void SetProductSale(ProductSale productSale) {
		this.id.setProductSale(productSale);
	}
	
	
	@JsonIgnore
	public Sales getSales() {
		return this.id.getSales();
	}
	
	public void setSales(Sales sales) {
		this.id.setSales(sales);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SalesItem other = (SalesItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
