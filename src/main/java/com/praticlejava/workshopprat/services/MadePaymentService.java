package com.praticlejava.workshopprat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticlejava.workshopprat.entities.MadePayment;
import com.praticlejava.workshopprat.repositories.MadePaymentRepository;

@Service
public class MadePaymentService {
	@Autowired
	MadePaymentRepository madePaymentRepository;
	
	public List<MadePayment> findAll(){
		return madePaymentRepository.findAll();
	}
	
	public Optional<MadePayment> findById(Long id){
		Optional<MadePayment> obj = madePaymentRepository.findById(id);
		return Optional.ofNullable(obj.get());
	}
}
