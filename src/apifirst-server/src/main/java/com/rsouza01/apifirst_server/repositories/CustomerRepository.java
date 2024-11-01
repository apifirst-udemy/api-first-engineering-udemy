package com.rsouza01.apifirst_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsouza01.apifirst_server.domain.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
