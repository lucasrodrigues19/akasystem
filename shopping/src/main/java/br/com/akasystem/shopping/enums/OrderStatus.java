package br.com.akasystem.shopping.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {

	WAITING_CONFIRMATION("WAITING_CONFIRMATION"),
	CONFIRMED("CONFIRMED"),
	WAITING_PAYAMENT("WAITING_PAYAMENT"),
	PAID("PAID"),
	ON_CARRIAGE("ON_CARRIAGE"),
	DELIVERED("DELIVERED");
	
	private String name;
	
	OrderStatus(String name) {
		this.name = name;
	}
}
