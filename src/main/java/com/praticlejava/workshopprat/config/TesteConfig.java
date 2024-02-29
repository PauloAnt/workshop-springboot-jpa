package com.praticlejava.workshopprat.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.praticlejava.workshopprat.entities.User;
import com.praticlejava.workshopprat.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		LocalDate date = LocalDate.of(2005, 03, 22);
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", date, "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", date, "123456"); 
		
		List<User> lista = new ArrayList();
		lista.add(u1);
		lista.add(u2);
		userRepository.saveAll(lista);
		
	}
}
