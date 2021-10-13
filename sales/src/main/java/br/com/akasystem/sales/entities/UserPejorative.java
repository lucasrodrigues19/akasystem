
package br.com.akasystem.sales.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "tbuserpejorative")
@PrimaryKeyJoinColumn(name="id")
public class UserPejorative extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "cnpj", nullable = false, length = 14)
	private String cnpj;
	
	@JsonIgnore
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userPejorative")
	private Set<Sales> setSales= new HashSet<>();
	
	
	@JsonIgnore
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userPejorative")
	private Set<ProductSale> setProductSale = new HashSet<>();
}
