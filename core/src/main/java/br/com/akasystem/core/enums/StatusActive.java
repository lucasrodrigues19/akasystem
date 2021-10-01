package br.com.akasystem.core.enums;

import lombok.Getter;

@Getter
public enum StatusActive {

	ACTIVE(1),
	REMOVE(0),
	INATIVE(3);

	private int INT;
	
	StatusActive(int i) {
		this.INT = i;
	}
	
}
