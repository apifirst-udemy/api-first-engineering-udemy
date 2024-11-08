package com.rsouza01.apifirst_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.rsouza01.apifirst.model.OrderDto;
import com.rsouza01.apifirst.model.OrderCreateDto;
import com.rsouza01.apifirst_server.domain.Customer;
import com.rsouza01.apifirst_server.domain.Order;
import com.rsouza01.apifirst_server.domain.OrderLine;
import com.rsouza01.apifirst_server.domain.OrderStatusEnum;
import com.rsouza01.apifirst_server.domain.Product;
import com.rsouza01.apifirst_server.mappers.OrderMapper;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst_server.repositories.OrderRepository;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    private final OrderMapper orderMapper;

    @Override
    public List<OrderDto> listOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .map(orderMapper::orderToOrderDto)
                .toList();
    }

    @Override
    public OrderDto getOrderById(UUID orderId) {
        return orderRepository.findById(orderId).map(orderMapper::orderToOrderDto).orElseThrow();
    }

    @Override
    public OrderDto saveNewOrder(OrderCreateDto orderCreate) {
        Customer orderCustomer = customerRepository.findById(orderCreate.getCustomerId()).orElseThrow();

        Order.OrderBuilder builder = Order.builder()
                .customer(orderCustomer)
                .orderStatus(OrderStatusEnum.NEW);

        List<OrderLine> orderLines = new ArrayList<>();

        orderCreate.getOrderLines()
                .forEach(orderLineCreate -> {
                    Product product = productRepository.findById(orderLineCreate.getProductId())
                            .orElseThrow();

                    orderLines.add(OrderLine.builder()
                            .product(product)
                            .orderQuantity(orderLineCreate.getOrderQuantity())
                            .build());
                });

        Order savedOrder = orderRepository.saveAndFlush(builder.orderLines(orderLines).build());
        return orderMapper.orderToOrderDto(savedOrder);

    }
}
