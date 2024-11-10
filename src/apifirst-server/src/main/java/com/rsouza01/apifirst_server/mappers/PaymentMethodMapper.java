package com.rsouza01.apifirst_server.mappers;

import com.rsouza01.apifirst.model.PaymentMethodDto;
import com.rsouza01.apifirst_server.domain.PaymentMethod;

import org.mapstruct.Mapper;

@Mapper
public interface PaymentMethodMapper {
        PaymentMethodDto paymentMethodToPaymentMethodDto(PaymentMethod paymentMethod);
}
