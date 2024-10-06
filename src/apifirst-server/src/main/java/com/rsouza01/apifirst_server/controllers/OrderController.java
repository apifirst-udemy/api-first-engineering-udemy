package com.rsouza01.apifirst_server.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.rsouza01.apifirst.model.OrderDto;
import com.rsouza01.apifirst.model.OrderCreateDto;
import com.rsouza01.apifirst_server.services.OrderService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping(OrderController.BASE_URL)
public class OrderController {

    public static final String BASE_URL = "/v1/orders";
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> listOrders() {
        return ResponseEntity.ok(orderService.listOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
    
    @PostMapping
    public ResponseEntity<Void> saveNewOrder(@RequestBody OrderCreateDto orderCreate) {
        
        OrderDto savedOrder = orderService.saveNewOrder(orderCreate);

        UriComponents uriComponents = UriComponentsBuilder.fromPath(BASE_URL + "/{order_id}").buildAndExpand(savedOrder.getId());

        return ResponseEntity.created(URI.create(uriComponents.getPath())).build();
    }

}
