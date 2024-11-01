package com.rsouza01.apifirst_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsouza01.apifirst_server.domain.Order;

import java.util.UUID;


public interface OrderRepository extends JpaRepository<Order, UUID> {

}
