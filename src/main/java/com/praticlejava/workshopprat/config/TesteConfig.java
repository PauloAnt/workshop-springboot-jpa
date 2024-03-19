package com.praticlejava.workshopprat.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.praticlejava.workshopprat.entities.Category;
import com.praticlejava.workshopprat.entities.MadePayment;
import com.praticlejava.workshopprat.entities.Order;
import com.praticlejava.workshopprat.entities.Payment;
import com.praticlejava.workshopprat.entities.Product;
import com.praticlejava.workshopprat.entities.User;
import com.praticlejava.workshopprat.entities.enums.OrderStatus;
import com.praticlejava.workshopprat.entities.enums.PaymentMethod;
import com.praticlejava.workshopprat.repositories.CategoriesRepository;
import com.praticlejava.workshopprat.repositories.MadePaymentRepository;
import com.praticlejava.workshopprat.repositories.OrderRepository;
import com.praticlejava.workshopprat.repositories.PaymentRepository;
import com.praticlejava.workshopprat.repositories.ProductRepository;
import com.praticlejava.workshopprat.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoriesRepository categoriesRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private MadePaymentRepository madePaymentRepository;

	@Override
	public void run(String... args) throws Exception {
		LocalDate date = LocalDate.of(2005, 03, 22);
		OrderStatus status1 = OrderStatus.E1;
		OrderStatus status2 = OrderStatus.E5;
		
		Category c1 = new Category();
		c1.setName("Eletronicos");
		Category c2 = new Category();
		c2.setName("Casa");
		
		Product p1 = new Product(null, "Computador", 2000, 100, c1);
		Product p2 = new Product(null, "Copo", 10, 200, c2);
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", date, "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", date, "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, status1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, status2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, status2);
		
		o1.getProducts().add(p1);
		o1.getProducts().add(p2);
		o2.getProducts().add(p1);
		
		c1.getProducts().add(p1);
		c2.getProducts().add(p2);
		
		PaymentMethod pym = PaymentMethod.P1;
		int soma = 0;
		
		for(Product obj : o1.getProducts()) {
			soma += obj.getPrice();
		}
		
		Payment pm1 = new Payment(null, pym, soma, Instant.now()); 
		
		MadePayment mp1 = new MadePayment();
		mp1.realizarPagamento(pm1);
	
		o1.setMadePayment(mp1);
		
		List<User> list_user = new ArrayList();
		list_user.add(u1);
		list_user.add(u2);
		
		List<Order> list_order = new ArrayList();
		list_order.add(o1);
		list_order.add(o2);
		list_order.add(o3);
		
		paymentRepository.save(pm1);
		madePaymentRepository.save(mp1);
		userRepository.saveAll(list_user);
		categoriesRepository.saveAll(Arrays.asList(c1, c2));
		productRepository.saveAll(Arrays.asList(p1, p2));
		orderRepository.saveAll(list_order);
		
		
	}
}
