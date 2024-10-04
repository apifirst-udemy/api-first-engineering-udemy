package com.rsouza01.apifirst_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.rsouza01.apifirst.model.Customer;
import com.rsouza01.apifirst.model.Order;
import com.rsouza01.apifirst.model.OrderCreate;
import com.rsouza01.apifirst.model.OrderCustomer;
import com.rsouza01.apifirst.model.OrderLine;
import com.rsouza01.apifirst.model.OrderProduct;
import com.rsouza01.apifirst.model.Product;
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

    @Override
    public List<Order> listOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public Order getOrderById(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public Order saveNewOrder(OrderCreate orderCreate) {
        Customer orderCustomer = customerRepository.findById(orderCreate.getCustomerId()).orElseThrow();

        Order.OrderBuilder builder = Order.builder()
                .customer(OrderCustomer.builder()
                        .id(orderCustomer.getId())
                        .name(orderCustomer.getName())
                        .billToAddress(orderCustomer.getBillToAddress())
                        .shipToAddress(orderCustomer.getShipToAddress())
                        .phone(orderCustomer.getPhone())
                        .selectedPaymentMethod(orderCustomer.getPaymentMethods().stream()
                                .filter(paymentMethod -> paymentMethod.getId()
                                        .equals(orderCreate.getSelectPaymentMethod()))
                                .findFirst().orElseThrow())
                        .build())
                .orderStatus(Order.OrderStatusEnum.NEW);

        List<OrderLine> orderLines = new ArrayList<>();

        orderCreate.getOrderLines()
                .forEach(orderLineCreate -> {
                    Product product = productRepository.findById(orderLineCreate.getProductId()).orElseThrow();

                    orderLines.add(OrderLine.builder()
                            .product(OrderProduct.builder()
                                    .id(product.getId())
                                    .description(product.getDescription())
                                    .price(product.getPrice())
                                    .build())
                            .orderQuantity(orderLineCreate.getOrderQuantity())
                            .build());
                });

        return orderRepository.save(builder.orderLines(orderLines).build());
    }
}
