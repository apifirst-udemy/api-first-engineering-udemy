package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;

import com.rsouza01.apifirst.model.OrderCreateDto;
import com.rsouza01.apifirst.model.OrderDto;

public interface OrderService {

    List<OrderDto> listOrders();

    OrderDto getOrderById(UUID orderId);

    OrderDto saveNewOrder(OrderCreateDto orderCreate);
}
