package br.com.akasystem.shopping.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbuserphysical")
public class UserPhysical extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;
	
	@JsonIgnore//Associação de mão dupla, para que quando busque o order e o user do order não busque o order, para não entrar em loop
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Order> setOrders = new HashSet<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((setOrders == null) ? 0 : setOrders.hashCode());
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
		UserPhysical other = (UserPhysical) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (setOrders == null) {
			if (other.setOrders != null)
				return false;
		} else if (!setOrders.equals(other.setOrders))
			return false;
		return true;
	}
	
	
}
