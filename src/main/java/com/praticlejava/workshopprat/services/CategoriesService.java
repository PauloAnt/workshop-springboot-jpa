package com.praticlejava.workshopprat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticlejava.workshopprat.entities.Category;
import com.praticlejava.workshopprat.repositories.CategoriesRepository;

@Service
public class CategoriesService {
	@Autowired
	CategoriesRepository categoriesRepository;
	
	public List<Category> findAll(){
		return categoriesRepository.findAll();
	}
	
	public Optional<Category> findById(Long id){
		Optional<Category> obj = categoriesRepository.findById(id);
		return Optional.ofNullable(obj.get());
	}
}
