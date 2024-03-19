package com.praticlejava.workshopprat.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "madepayment")
public class MadePayment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	private boolean paid = false;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
	private Payment payment;
	
	public MadePayment() {}
	
	public MadePayment(boolean paid, Payment payment) {
		super();
		this.paid = paid;
		this.payment = payment;
	}



	public void realizarPagamento(Payment py) {
		paid = true;
		payment = new Payment(null, py.getMethod(), py.getValor(), py.getMoment());
	}
	
	public boolean isPaid() {
		return paid;
	}

	public Payment getPayment() {
		return payment;
	}


	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	
	
}
