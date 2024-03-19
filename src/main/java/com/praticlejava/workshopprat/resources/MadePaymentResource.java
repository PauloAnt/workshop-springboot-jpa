package com.praticlejava.workshopprat.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticlejava.workshopprat.entities.MadePayment;
import com.praticlejava.workshopprat.services.MadePaymentService;

@RestController
@RequestMapping(value = "/madepayment")
public class MadePaymentResource {
	
	@Autowired
	MadePaymentService madePaymentService;
	
	@GetMapping
	public ResponseEntity<List<MadePayment>> findAll(){
		List<MadePayment> found_list = madePaymentService.findAll();
		return ResponseEntity.ok().body(found_list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<MadePayment>>findById(Long id){
		Optional<MadePayment> obj = madePaymentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}