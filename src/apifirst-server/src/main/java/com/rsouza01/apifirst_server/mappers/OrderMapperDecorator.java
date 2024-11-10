package com.rsouza01.apifirst_server.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.rsouza01.apifirst.model.OrderCreateDto;
import com.rsouza01.apifirst.model.OrderDto;
import com.rsouza01.apifirst_server.domain.Customer;
import com.rsouza01.apifirst_server.domain.Order;
import com.rsouza01.apifirst_server.domain.OrderLine;
import com.rsouza01.apifirst_server.domain.OrderStatusEnum;
import com.rsouza01.apifirst_server.domain.PaymentMethod;
import com.rsouza01.apifirst_server.domain.Product;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

public abstract class OrderMapperDecorator implements OrderMapper {

    @Autowired
    @Qualifier("delegate")
    private OrderMapper orderMapperDelegate;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    @Override
    public Order dtoToOrder(OrderCreateDto orderCreateDto) {
        Customer orderCustomer = customerRepository.findById(orderCreateDto.getCustomerId()).orElseThrow();

        PaymentMethod selectedPaymentMethod = orderCustomer.getPaymentMethods().stream()
                .filter(pm -> pm.getId().equals(orderCreateDto.getSelectPaymentMethodId()))
                .findFirst()
                .orElseThrow();

        Order.OrderBuilder builder = Order.builder()
                .customer(orderCustomer)
                .selectedPaymentMethod(selectedPaymentMethod)
                .orderStatus(OrderStatusEnum.NEW);

        List<OrderLine> orderLines = new ArrayList<>();

        orderCreateDto.getOrderLines()
                .forEach(orderLineCreate -> {
                    Product product = productRepository.findById(orderLineCreate.getProductId()).orElseThrow();

                    orderLines.add(OrderLine.builder()
                            .product(product)
                            .orderQuantity(orderLineCreate.getOrderQuantity())
                            .build());
                });

        return builder.orderLines(orderLines).build();
    }

    @Override
    public Order dtoToOrder(OrderDto orderDto) {
        return orderMapperDelegate.dtoToOrder(orderDto);
    }

    @Override
    public OrderDto orderToDto(Order order) {
        OrderDto orderDto = orderMapperDelegate.orderToDto(order);
        orderDto.getCustomer()
                .selectedPaymentMethod(
                        paymentMethodMapper.paymentMethodToPaymentMethodDto(order.getSelectedPaymentMethod()));

        return orderDto;
    }

}