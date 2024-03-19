package com.praticlejava.workshopprat.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticlejava.workshopprat.entities.Order;
import com.praticlejava.workshopprat.services.OrderServices;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {
	@Autowired
	private OrderServices orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> all_orders = orderService.findAll();
		return ResponseEntity.ok().body(all_orders);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Order>> findById(@PathVariable Long id){
		Optional<Order> found_order = orderService.findById(id);
		return ResponseEntity.ok().body(found_order);
	}
}
