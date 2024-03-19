package com.praticlejava.workshopprat.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticlejava.workshopprat.entities.Category;
import com.praticlejava.workshopprat.services.CategoriesService;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {
	
	@Autowired
	CategoriesService categoriesService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> found_list = categoriesService.findAll();
		return ResponseEntity.ok().body(found_list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<Category>>findById(Long id){
		Optional<Category> obj = categoriesService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}