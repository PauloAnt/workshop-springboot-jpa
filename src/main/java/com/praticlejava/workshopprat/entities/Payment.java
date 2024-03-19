package com.praticlejava.workshopprat.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.praticlejava.workshopprat.entities.enums.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "method")
	PaymentMethod method;
	
	@Column(name = "valor", columnDefinition = "float")
	private double valor;
	
	@Column(name = "moment")
	private Instant moment;
	
	public Payment() {}

	public Payment(Long id, PaymentMethod method, double valor, Instant moment) {
		this.id = id;
		this.method = method;
		this.valor = valor;
		this.moment = moment;
	}
	
	public Long getId() {
		return id;
	}

	public PaymentMethod getMethod() {
		return method;
	}

	public double getValor() {
		return valor;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMethod(PaymentMethod method) {
		this.method = method;
	}

	public void setValue(double valor) {
		this.valor = valor;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
}
