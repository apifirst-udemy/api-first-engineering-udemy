package com.rsouza01.apifirst_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst.model.OrderDto;
import com.rsouza01.apifirst.model.OrderCreateDto;
import com.rsouza01.apifirst.model.OrderCustomerDto;
import com.rsouza01.apifirst.model.OrderLineDto;
import com.rsouza01.apifirst.model.OrderProductDto;
import com.rsouza01.apifirst.model.ProductDto;
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
    public List<OrderDto> listOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public OrderDto getOrderById(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public OrderDto saveNewOrder(OrderCreateDto orderCreate) {
        CustomerDto orderCustomer = customerRepository.findById(orderCreate.getCustomerId()).orElseThrow();

        OrderDto.OrderDtoBuilder builder = OrderDto.builder()
                .customer(OrderCustomerDto.builder()
                        .id(orderCustomer.getId())
                        .name(orderCustomer.getName())
                        .billToAddress(orderCustomer.getBillToAddress())
                        .shipToAddress(orderCustomer.getShipToAddress())
                        .phone(orderCustomer.getPhone())
                        .selectedPaymentMethod(orderCustomer.getPaymentMethods().stream()
                                .filter(paymentMethod -> paymentMethod.getId()
                                        .equals(orderCreate.getSelectPaymentMethodId()))
                                .findFirst().orElseThrow())
                        .build())
                .orderStatus(OrderDto.OrderStatusEnum.NEW);

        List<OrderLineDto> orderLines = new ArrayList<>();

        orderCreate.getOrderLines()
                .forEach(orderLineCreate -> {
                    ProductDto product = productRepository.findById(orderLineCreate.getProductId()).orElseThrow();

                    orderLines.add(OrderLineDto.builder()
                            .product(OrderProductDto.builder()
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
