package com.praticlejava.workshopprat.entities.enums;

public enum OrderStatus {
	E1("WAITING_PAYMENT", 1),
	E2("PAYMENT_COMPLETED", 2),
	E3("WAITING_ORDER", 3),
	E4("ORDER_COMPLETED", 4),
	E5("PRODUCT_SENT", 5),
	E6("ON_DELIVERY_ROUTE", 6);
	
	int id;
	String description;

	OrderStatus(String description, int id) {
		this.description = description;
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getId() {
		return id;
	}
}
