package br.com.akasystem.core.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import br.com.akasystem.core.enums.FileType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbfile")
public class File extends SingleMainEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "filetype", nullable = false, length = 80)
	private FileType fileType;

	@Lob
	@Column(name = "source", nullable = false)
	private byte[] source;
	
	@Column(name = "productid", nullable = true)
	private String productId;
	
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
		File other = (File) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
