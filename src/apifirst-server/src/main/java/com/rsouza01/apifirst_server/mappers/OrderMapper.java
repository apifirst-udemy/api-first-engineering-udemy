package com.rsouza01.apifirst_server.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rsouza01.apifirst.model.OrderCreateDto;
import com.rsouza01.apifirst.model.OrderDto;
import com.rsouza01.apifirst_server.domain.Order;

@Mapper
public interface OrderMapper {

    @Mapping(target = "shipmentInfo", ignore = true)
    // @Mapping(target = "selectedPaymentMethod", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Order orderCreateDtoToOrder(OrderCreateDto orderCreateDto);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    Order orderDtoToOrder(OrderDto orderDto);

    OrderDto orderToOrderDto(Order order);
}
