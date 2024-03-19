package com.praticlejava.workshopprat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.praticlejava.workshopprat.entities.User;
import com.praticlejava.workshopprat.repositories.UserRepository;
import com.praticlejava.workshopprat.services.exceptions.DatabaseException;
import com.praticlejava.workshopprat.services.exceptions.ResourceNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public User update(Long id, User user) {
		User us = userRepository.getReferenceById(id);
		us.setUsername(user.getUsername());
		us.setEmail(user.getEmail());
		us.setBirthday(user.getBirthday());
		return userRepository.save(us);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
