package br.com.akasystem.core.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.akasystem.core.entities.main.MainEntity;
import br.com.akasystem.core.entities.pk.PrivilegePK;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Data
@Entity
@Table(name = "tbprivilege")
public class Privilege extends MainEntity{

	@Setter(AccessLevel.NONE)
	@EmbeddedId
	private PrivilegePK id = new PrivilegePK();
	
	
	@JsonIgnore
	public User getUser() {
		return this.id.getUser();
	}
	
	public void setUser(User user) {
		this.id.setUser(user);
	}
	
	
	public Roles getRoles() {
		return this.getRoles();
	}
	
	public void setRoles(Roles roles) {
		this.id.setRoles(roles);
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
		Privilege other = (Privilege) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
	
}
