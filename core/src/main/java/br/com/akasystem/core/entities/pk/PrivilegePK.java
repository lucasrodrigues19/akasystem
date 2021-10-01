package br.com.akasystem.core.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.akasystem.core.entities.Category;
import br.com.akasystem.core.entities.Product;
import br.com.akasystem.core.entities.Roles;
import br.com.akasystem.core.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@Embeddable
public class PrivilegePK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "rolesid", nullable = false, foreignKey = @ForeignKey(name = "fk_privilegexroles"))
	private Roles roles;
	
	@ManyToOne
	@JoinColumn(name = "userid",nullable = false, foreignKey = @ForeignKey(name = "fk_privilegexuser"))
	private User user;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		PrivilegePK other = (PrivilegePK) obj;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	
}
