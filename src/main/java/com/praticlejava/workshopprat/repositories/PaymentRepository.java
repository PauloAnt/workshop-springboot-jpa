package com.praticlejava.workshopprat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticlejava.workshopprat.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
