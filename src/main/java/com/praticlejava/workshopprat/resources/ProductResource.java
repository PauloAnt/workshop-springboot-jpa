package com.praticlejava.workshopprat.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticlejava.workshopprat.entities.Product;
import com.praticlejava.workshopprat.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> lista = productService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
		Optional<Product> found = productService.findById(id);
		return ResponseEntity.ok().body(found);
	}
}
