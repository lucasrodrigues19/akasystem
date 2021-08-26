package br.com.akasystem.akasales.enums;

import lombok.Getter;

@Getter
public enum AKAOrderStatus {
	WAITING_PAYAMENT("WAITING_PAYAMENT"),
	PAID("PAID"),
	SHIPPED("SHIPPED"),
	DELIVERED("DELIVERED"),
	CANCELED("DELIVERED");

	private String name;
	
	private AKAOrderStatus(String name) {
		this.name =  name;
	}
}
