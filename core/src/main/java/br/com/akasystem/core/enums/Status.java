package br.com.akasystem.core.enums;

import lombok.Getter;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@Getter
public enum Status {

	REMOVE(0),
	ACTIVE(1),
	INATIVE(2);

	private int INT;
	
	Status(int i) {
		this.INT = i;
	}
	
}
