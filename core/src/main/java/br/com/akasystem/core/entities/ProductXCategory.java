package br.com.akasystem.core.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.main.MainEntity;
import br.com.akasystem.core.entities.pk.ProductXCategoryPK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "tbproductxcategory")
public class ProductXCategory extends MainEntity implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProductXCategoryPK id = new ProductXCategoryPK();
	
	public Category getCategory() {
		return this.id.getCategory();
	}
	
	public void setCategory (Category category) {
		this.id.setCategory(category);
	}
	
	@JsonIgnore
	public Product getProduct() {
		return this.id.getProduct();
	}
	
	public void setProduct (Product akaProduct) {
		this.id.setProduct(akaProduct);
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
		ProductXCategory other = (ProductXCategory) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
