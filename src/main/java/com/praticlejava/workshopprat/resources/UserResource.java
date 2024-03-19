package com.praticlejava.workshopprat.resources;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticlejava.workshopprat.entities.User;
import com.praticlejava.workshopprat.services.UserServices;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	@Autowired
	private UserServices userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
		Optional<User> user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		User us = userService.insert(user);
		return ResponseEntity.ok().body(us);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		User us = userService.update(id, user);
		return ResponseEntity.ok().body(us);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
