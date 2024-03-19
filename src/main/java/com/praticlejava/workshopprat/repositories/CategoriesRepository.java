package com.praticlejava.workshopprat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticlejava.workshopprat.entities.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

}
