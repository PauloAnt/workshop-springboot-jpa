package com.praticlejava.workshopprat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticlejava.workshopprat.entities.Product;
import com.praticlejava.workshopprat.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(Long id){
		Optional<Product> obj = productRepository.findById(id);
		return Optional.ofNullable(obj.get());
	}
}
