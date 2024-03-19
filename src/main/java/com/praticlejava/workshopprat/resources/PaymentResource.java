package com.praticlejava.workshopprat.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticlejava.workshopprat.entities.Payment;
import com.praticlejava.workshopprat.services.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentResource {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public ResponseEntity<List<Payment>> findAll(){
		List<Payment> found_list = paymentService.findAll();
		return ResponseEntity.ok().body(found_list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<Payment>>findById(@PathVariable Long id){
		Optional<Payment> obj = paymentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}