package com.praticlejava.workshopprat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticlejava.workshopprat.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
