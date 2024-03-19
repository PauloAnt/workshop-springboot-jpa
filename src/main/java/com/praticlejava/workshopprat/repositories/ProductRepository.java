package com.praticlejava.workshopprat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticlejava.workshopprat.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
