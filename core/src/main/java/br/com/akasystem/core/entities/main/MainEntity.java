package br.com.akasystem.core.entities.main;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import br.com.akasystem.core.enums.StatusActive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/09/03
 * @param <I> Tipo do identificador
 */
@Getter
@Setter
@ToString
@MappedSuperclass
@Check(constraints = "(name <> '')")
public abstract class MainEntity<I> {

	
	@Column(name = "name",length = 255, nullable = false)
	private String name;
	
	@Column(name = "dtinsert", nullable = false)
	private LocalDateTime dtInsert;
	
	@Column(name = "dtupdate", nullable = false)
	private LocalDateTime dtUpdate;
	
	@Column(name = "idinsert", nullable = false)
	@Type(type="uuid-char")
	private UUID idInsert;
	
	@Column(name = "idupdate", nullable = false)
	@Type(type="uuid-char")
	private UUID idUpdate;
	
	@Column(name = "statusactive", nullable = false, columnDefinition = "numeric(1)")
	@Enumerated(EnumType.ORDINAL)
	private StatusActive statusActive;
}
