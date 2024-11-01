package com.rsouza01.apifirst_server.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst_server.domain.Customer;

@Mapper
public interface CustomerMapper {
     CustomerDto customerToDto(Customer customer);

    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    Customer dtoToCustomer(CustomerDto customerDto);
}
