package com.praticlejava.workshopprat.entities.enums;

public enum PaymentMethod {
	P1("Credit", 1),
	P2("Debit", 2),
	P3("Ticket", 3),
	P4("PIX", 4);
	
	String method;
	int id;
	
	PaymentMethod(String method, int id) {
		this.method = method;
		this.id = id;
	}
	
	public String getMethod() {
		return method;
	}

	public int getId() {
		return id;
	}
}

