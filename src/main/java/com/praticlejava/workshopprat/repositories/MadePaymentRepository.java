package com.praticlejava.workshopprat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticlejava.workshopprat.entities.MadePayment;

public interface MadePaymentRepository extends JpaRepository<MadePayment, Long> {

}
