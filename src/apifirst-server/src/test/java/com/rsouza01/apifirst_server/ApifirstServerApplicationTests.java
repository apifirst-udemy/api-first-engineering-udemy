package com.rsouza01.apifirst_server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst_server.repositories.OrderRepository;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApifirstServerApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

    @Autowired
	OrderRepository orderRepository;

    @Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testDataLoad() {
		assertThat(customerRepository.count()).isGreaterThan(0L);
		assertThat(orderRepository.count()).isGreaterThan(0L);
		assertThat(productRepository.count()).isGreaterThan(0L);
	}
}
