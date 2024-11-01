package com.rsouza01.apifirst_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsouza01.apifirst_server.domain.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
