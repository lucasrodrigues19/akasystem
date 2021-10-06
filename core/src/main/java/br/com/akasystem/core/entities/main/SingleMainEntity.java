package br.com.akasystem.core.entities.main;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
@Setter
@MappedSuperclass
public abstract class SingleMainEntity extends MainEntity implements Serializable{

	private static final long serialVersionUID = -8024087884425473851L;
	
	@Id
	@Type(type="uuid-char")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	
	public void merge(SingleMainEntity other) {
		if(this.id == null)
			this.id = other.getId();
		
		super.merge(other);
		
	}
}
