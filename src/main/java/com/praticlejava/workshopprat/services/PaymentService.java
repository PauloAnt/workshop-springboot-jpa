package com.praticlejava.workshopprat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticlejava.workshopprat.entities.Payment;
import com.praticlejava.workshopprat.repositories.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}
	
	public Optional<Payment> findById(Long id){
		Optional<Payment> obj = paymentRepository.findById(id);
		return Optional.ofNullable(obj.get());
	}
}
