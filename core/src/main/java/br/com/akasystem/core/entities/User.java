package br.com.akasystem.core.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbuser", uniqueConstraints = { @UniqueConstraint(name = "uk_emailxphone", columnNames = { "email", "phone" }) })
@Inheritance(strategy=InheritanceType.JOINED)
public class User extends SingleMainEntity<UUID>{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Column(name = "phone", length = 14, nullable = false)
	private String phone;
	
	@Column(name = "password", length = 25, nullable = false)
	private String password;
	
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "id.user")
	private Set<Privilege> setPrivilege = new HashSet<>();
	
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
		User other = (User) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
