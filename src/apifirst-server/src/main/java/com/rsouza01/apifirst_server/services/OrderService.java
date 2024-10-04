package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;

import com.rsouza01.apifirst.model.Order;
import com.rsouza01.apifirst.model.OrderCreate;


public interface OrderService {

    List<Order> listOrders();

    Order getOrderById(UUID orderId);

    Order saveNewOrder(OrderCreate orderCreate);
}
