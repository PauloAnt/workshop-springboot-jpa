package com.praticlejava.workshopprat.resources;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticlejava.workshopprat.entities.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	@GetMapping
	
	public ResponseEntity<User> findAll(){
		LocalDate date = LocalDate.of(2005, 03, 22);
		User user = new User(1L, "paulo9676", "paulo@gmail.com", date, "paulo123");
		return ResponseEntity.ok().body(user);
	}
}
