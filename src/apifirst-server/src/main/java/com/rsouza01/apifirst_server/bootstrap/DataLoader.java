package com.rsouza01.apifirst_server.bootstrap;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.time.OffsetDateTime;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rsouza01.apifirst.model.Address;
import com.rsouza01.apifirst.model.Category;
import com.rsouza01.apifirst.model.Customer;
import com.rsouza01.apifirst.model.Dimentions;
import com.rsouza01.apifirst.model.Image;
import com.rsouza01.apifirst.model.Name;
import com.rsouza01.apifirst.model.Order;
import com.rsouza01.apifirst.model.OrderCustomer;
import com.rsouza01.apifirst.model.OrderLine;
import com.rsouza01.apifirst.model.OrderProduct;
import com.rsouza01.apifirst.model.PaymentMethod;
import com.rsouza01.apifirst.model.Product;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst_server.repositories.OrderRepository;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final List<Customer> customersList = new ArrayList<Customer>();
    private final List<Product> productsList = new ArrayList<Product>();
    private final List<Order> ordersList = new ArrayList<Order>();

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
        Order order1 = Order.builder()
            .id(UUID.randomUUID())
            .customer(OrderCustomer.builder().build())
            .orderLines(List.of(
                OrderLine.builder()
                    .id(UUID.randomUUID())
                    .product(OrderProduct.builder().build())
                    .orderQuantity(1)
                    .shipQuantity(10)
                    .dateCreated(OffsetDateTime.now())
                    .dateUpdated(OffsetDateTime.now())
                    .build(),
                OrderLine.builder()
                    .id(UUID.randomUUID())
                    .product(OrderProduct.builder().build())
                    .orderQuantity(1)
                    .shipQuantity(10)
                    .dateCreated(OffsetDateTime.now())
                    .dateUpdated(OffsetDateTime.now())
                    .build()
            ))
            .dateCreated(OffsetDateTime.now())
            .dateUpdated(OffsetDateTime.now())
            .build();

        ordersList.add(order1);
    }

    private void initProductList() {

        List<Category> categories = List.of(
                Category.builder()
                        .id(UUID.randomUUID())
                        .category("Category 1")
                        .description("Description of Category 1")
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build(),
                Category.builder()
                        .id(UUID.randomUUID())
                        .category("Category 2")
                        .description("Description of Category 2")
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build(),
                Category.builder()
                        .id(UUID.randomUUID())
                        .category("Category 3")
                        .description("Description of Category 3")
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()

        );

        Product product1 = Product.builder()
                .description("Product 1")
                .price("123")
                .cost("100")
                .dimentions(Dimentions.builder().width(10).height(10).length(10).build())
                .categories(List.of(categories.get(0), categories.get(1)))
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .images(List.of(
                        Image.builder()
                                .id(UUID.randomUUID())
                                .url("url-1-product-1")
                                .altText("Alt text")
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build(),
                        Image.builder()
                                .id(UUID.randomUUID())
                                .url("url-2-product-1")
                                .altText("Alt text")
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build()))
                .build();

        Product product2 = Product.builder()
                .description("Product 2")
                .price("321")
                .cost("300")
                .dimentions(Dimentions.builder().width(100).height(100).length(100).build())
                .categories(List.of(categories.get(1), categories.get(2)))
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .images(List.of(
                        Image.builder()
                                .id(UUID.randomUUID())
                                .url("url-1-product-2")
                                .altText("Alt text")
                                .dateCreated(OffsetDateTime.now())
                                .dateUpdated(OffsetDateTime.now())
                                .build(),
                        Image.builder()
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
        Address address1 = Address.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        Customer customer1 = Customer.builder()
                .name(Name.builder()
                        .firstName("John")
                        .lastName("Thompson")
                        .build())
                .billToAddress(address1)
                .shipToAddress(address1)
                .email("john@springframework.guru")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("Card 1")
                        .cvv(123)
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()))
                .build();

        Address address2 = Address.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name(Name.builder()
                        .firstName("Jim")
                        .lastName("Smith")
                        .build())
                .billToAddress(address2)
                .shipToAddress(address2)
                .email("jim@springframework.guru")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethod.builder()
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

}
