package br.com.akasystem.core.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.akasystem.core.entities.Category;
import br.com.akasystem.core.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@Embeddable
public class ProductXCategoryPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "productid", foreignKey = @ForeignKey(name = "fk_productcategoryxproduct"))
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "categoryid", foreignKey = @ForeignKey(name = "fk_productcategoryxcategory"))
	private Category category;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		ProductXCategoryPK other = (ProductXCategoryPK) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
}
