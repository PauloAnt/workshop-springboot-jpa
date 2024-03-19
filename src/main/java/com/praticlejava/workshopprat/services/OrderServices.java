package com.praticlejava.workshopprat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticlejava.workshopprat.entities.Order;
import com.praticlejava.workshopprat.repositories.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Optional<Order> findById(Long id){
		Optional<Order> obj = orderRepository.findById(id);
		return Optional.ofNullable(obj.get());
	}
}
