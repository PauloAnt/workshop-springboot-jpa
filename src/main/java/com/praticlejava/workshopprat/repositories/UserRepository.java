package com.praticlejava.workshopprat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticlejava.workshopprat.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
