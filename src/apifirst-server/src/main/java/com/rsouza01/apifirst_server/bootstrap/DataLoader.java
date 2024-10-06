package com.rsouza01.apifirst_server.bootstrap;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.time.OffsetDateTime;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rsouza01.apifirst.model.AddressDto;
import com.rsouza01.apifirst.model.CategoryDto;
import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst.model.DimensionsDto;
import com.rsouza01.apifirst.model.ImageDto;
import com.rsouza01.apifirst.model.NameDto;
import com.rsouza01.apifirst.model.OrderDto;
import com.rsouza01.apifirst.model.OrderCustomerDto;
import com.rsouza01.apifirst.model.OrderLineDto;
import com.rsouza01.apifirst.model.OrderProductDto;
import com.rsouza01.apifirst.model.PaymentMethodDto;
import com.rsouza01.apifirst.model.ProductDto;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst_server.repositories.OrderRepository;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final List<CustomerDto> customersList = new ArrayList<CustomerDto>();
    private final List<ProductDto> productsList = new ArrayList<ProductDto>();
    private final List<OrderDto> ordersList = new ArrayList<OrderDto>();

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        initCustomerList();
        initProductList();
        initOrdersList();

        initCustomerRepository();
        initProductRepository();
        initOrderRepository();

    }

    private void initProductRepository() {
        productsList.forEach(product -> productRepository.save(product));
    }

    private void initCustomerRepository() {
        customersList.forEach(customer -> customerRepository.save(customer));
    }

    private void initOrderRepository() {
        ordersList.forEach(order -> orderRepository.save(order));
    }

    private void initOrdersList() {
        OrderDto order1 = OrderDto.builder()
                .id(UUID.randomUUID())
                .customer(customerToOrderCustomer(customersList.get(0)))
                .orderLines(List.of(
                        OrderLineDto.builder()
                                .id(UUID.randomUUID())
                                .product(OrderProductDto.builder().build())
                                .orderQuantity(1)
                                .shipQuantity(10)
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build(),
                        OrderLineDto.builder()
                                .id(UUID.randomUUID())
                                .product(OrderProductDto.builder().build())
                                .orderQuantity(1)
                                .shipQuantity(10)
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build()))
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        ordersList.add(order1);
    }

    private void initProductList() {

        List<CategoryDto> categories = List.of(
                CategoryDto.builder()
                        .id(UUID.randomUUID())
                        .category("Category 1")
                        .description("Description of Category 1")
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build(),
                CategoryDto.builder()
                        .id(UUID.randomUUID())
                        .category("Category 2")
                        .description("Description of Category 2")
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build(),
                CategoryDto.builder()
                        .id(UUID.randomUUID())
                        .category("Category 3")
                        .description("Description of Category 3")
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()

        );

        ProductDto product1 = ProductDto.builder()
                .description("Product 1")
                .price("123")
                .cost("100")
                .dimensions(DimensionsDto.builder().width(10).height(10).length(10).build())
                .categories(List.of(categories.get(0), categories.get(1)))
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .images(List.of(
                        ImageDto.builder()
                                .id(UUID.randomUUID())
                                .url("url-1-product-1")
                                .altText("Alt text")
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build(),
                        ImageDto.builder()
                                .id(UUID.randomUUID())
                                .url("url-2-product-1")
                                .altText("Alt text")
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build()))
                .build();

        ProductDto product2 = ProductDto.builder()
                .description("Product 2")
                .price("321")
                .cost("300")
                .dimensions(DimensionsDto.builder().width(100).height(100).length(100).build())
                .categories(List.of(categories.get(1), categories.get(2)))
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .images(List.of(
                        ImageDto.builder()
                                .id(UUID.randomUUID())
                                .url("url-1-product-2")
                                .altText("Alt text")
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build(),
                        ImageDto.builder()
                                .id(UUID.randomUUID())
                                .url("url-2-product-2")
                                .altText("Alt text")
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build()))
                .build();

        productsList.add(product1);
        productsList.add(product2);
    }

    private void initCustomerList() {
        AddressDto address1 = AddressDto.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        CustomerDto customer1 = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(NameDto.builder()
                        .firstName("John")
                        .lastName("Thompson")
                        .build())
                .billToAddress(address1)
                .shipToAddress(address1)
                .email("john@springframework.guru")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethodDto.builder()
                        .displayName("Card 1")
                        .cvv(123)
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()))
                .build();

        AddressDto address2 = AddressDto.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        CustomerDto customer2 = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(NameDto.builder()
                        .firstName("Jim")
                        .lastName("Smith")
                        .build())
                .billToAddress(address2)
                .shipToAddress(address2)
                .email("jim@springframework.guru")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethodDto.builder()
                        .displayName("Card 2")
                        .cvv(123)
                        .cardNumber(1234888)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()))
                .build();

        customersList.add(customer1);
        customersList.add(customer2);
    }

    private static OrderCustomerDto customerToOrderCustomer(final CustomerDto customer) {
        OrderCustomerDto.OrderCustomerDtoBuilder orderCustomerBuilder = OrderCustomerDto.builder();

        orderCustomerBuilder.id(customer.getId());

        if (customer.getBillToAddress() != null) {
            orderCustomerBuilder.billToAddress(AddressDto.builder()
                    .id(UUID.randomUUID())
                    .addressLine1(customer.getBillToAddress().getAddressLine1())
                    .addressLine2(customer.getBillToAddress().getAddressLine2())
                    .city(customer.getBillToAddress().getCity())
                    .state(customer.getBillToAddress().getState())
                    .zip(customer.getBillToAddress().getZip())
                    .dateCreated(customer.getDateCreated())
                    .dateUpdated(customer.getDateUpdated())
                    .build());
        }

        if (customer.getShipToAddress() != null) {
            orderCustomerBuilder.shipToAddress(AddressDto.builder()
                    .id(UUID.randomUUID())
                    .addressLine1(customer.getShipToAddress().getAddressLine1())
                    .addressLine2(customer.getShipToAddress().getAddressLine2())
                    .city(customer.getShipToAddress().getCity())
                    .state(customer.getShipToAddress().getState())
                    .zip(customer.getShipToAddress().getZip())
                    .dateCreated(customer.getDateCreated())
                    .dateUpdated(customer.getDateUpdated())
                    .build());
        }

        OrderCustomerDto orderCustomer = orderCustomerBuilder
                .email(customer.getEmail())
                .name(customer.getName())
                .phone(customer.getPhone())
                .build();

        return orderCustomer;
    }
}
