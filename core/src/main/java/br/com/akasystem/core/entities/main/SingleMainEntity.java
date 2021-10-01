package br.com.akasystem.core.entities.main;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class SingleMainEntity<I> extends MainEntity<I> implements Serializable{

	private static final long serialVersionUID = -8024087884425473851L;
	
	@Id
	@Type(type="uuid-char")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
}
