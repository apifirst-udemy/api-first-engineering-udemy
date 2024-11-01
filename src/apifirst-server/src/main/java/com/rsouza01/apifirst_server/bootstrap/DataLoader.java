package com.rsouza01.apifirst_server.bootstrap;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.time.OffsetDateTime;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rsouza01.apifirst_server.domain.Order;
import com.rsouza01.apifirst_server.domain.OrderLine;
import com.rsouza01.apifirst_server.domain.PaymentMethod;
import com.rsouza01.apifirst_server.domain.Address;
import com.rsouza01.apifirst_server.domain.Category;
import com.rsouza01.apifirst_server.domain.Customer;
import com.rsouza01.apifirst_server.domain.Dimension;
import com.rsouza01.apifirst_server.domain.Image;
import com.rsouza01.apifirst_server.domain.Name;
import com.rsouza01.apifirst_server.domain.Product;
import com.rsouza01.apifirst_server.mappers.CustomerMapper;
import com.rsouza01.apifirst_server.repositories.CategoryRepository;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst_server.repositories.OrderRepository;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final List<Category> categoriesList = new ArrayList<Category>();
    private final List<Customer> customersList = new ArrayList<Customer>();
    private final List<Product> productsList = new ArrayList<Product>();
    private final List<Order> ordersList = new ArrayList<Order>();

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    CustomerMapper customerMapper;

    // @Override
    // public void run(String... args) throws Exception {

    // AddressDto address1 = AddressDto.builder()
    // .addressLine1("1234 W Some Street")
    // .city("Some City")
    // .state("FL")
    // .zip("33701")
    // .build();

    // CustomerDto customer1 = CustomerDto.builder()
    // .name(NameDto.builder()
    // .firstName("John")
    // .lastName("Thompson")
    // .build())
    // .billToAddress(address1)
    // .shipToAddress(address1)
    // .email("john@springframework.guru")
    // .phone("800-555-1212")
    // .paymentMethods(List.of(PaymentMethodDto.builder()
    // .displayName("My Card")
    // .cardNumber(12341234)
    // .expiryMonth(12)
    // .expiryYear(26)
    // .cvv(123)
    // .build()))
    // .build();

    // AddressDto address2 = AddressDto.builder()
    // .addressLine1("1234 W Some Street")
    // .city("Some City")
    // .state("FL")
    // .zip("33701")
    // .build();

    // CustomerDto customer2 = CustomerDto.builder()
    // .name(NameDto.builder()
    // .firstName("Jim")
    // .lastName("Smith")
    // .build())
    // .billToAddress(address2)
    // .shipToAddress(address2)
    // .email("jim@springframework.guru")
    // .phone("800-555-1212")
    // .paymentMethods(List.of(PaymentMethodDto.builder()
    // .displayName("My Other Card")
    // .cardNumber(1234888)
    // .expiryMonth(12)
    // .expiryYear(26)
    // .cvv(456)
    // .build()))
    // .build();
    // customersList.add(customer1);
    // customersList.add(customer2);

    // }

    @Override
    public void run(String... args) throws Exception {

        initCustomerList();
        initCategoriesList();
        // initProductList();
        // initOrdersList();

        initCustomerRepository();
        initCategoriesRepository();
        // initProductRepository();
        // initOrderRepository();

    }

    private void initProductRepository() {
        productsList.forEach(product -> productRepository.save(product));
    }

    private void initCustomerRepository() {
        customersList.forEach(customer -> customerRepository.save(customer));
    }

    private void initCategoriesRepository() {
        categoriesList.forEach(category -> categoryRepository.save(category));
    }

    private void initCategoriesList() {
        Category dryGoodsCategory = Category.builder().category("Dry goods").categoryCode("DRYGOODS")
                .description("Dry goods").build();
        categoriesList.add(dryGoodsCategory);

        Category electronicsCategory = Category.builder().category("Electronics").categoryCode("ELECTRONICS")
                .description("Electronics").build();
        categoriesList.add(electronicsCategory);

        Category magazinesCategory = Category.builder().category("Magazines").categoryCode("MAGAZINES")
                .description("Magazines").build();
        categoriesList.add(magazinesCategory);
    }

    private void initOrderRepository() {
        ordersList.forEach(order -> orderRepository.save(order));
    }

    private void initOrdersList() {
        Order order1 = Order.builder()
                .id(UUID.randomUUID())
                .customer(customersList.get(0))
                .orderLines(List.of(
                        OrderLine.builder()
                                .id(UUID.randomUUID())
                                .product(Product.builder().build())
                                .orderQuantity(1)
                                .shipQuantity(10)
                                .build(),
                        OrderLine.builder()
                                .id(UUID.randomUUID())
                                .product(Product.builder().build())
                                .orderQuantity(1)
                                .shipQuantity(10)
                                .build()))
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        ordersList.add(order1);
    }

    private void initProductList() {
        Product product1 = Product.builder()
                .description("Product 1")
                .price("123")
                .cost("100")
                .dimension(Dimension.builder().width(10).height(10).length(10).build())
                .categories(List.of(categoriesList.get(0), categoriesList.get(1)))
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
                .dimension(Dimension.builder().width(100).height(100).length(100).build())
                .categories(List.of(categoriesList.get(1), categoriesList.get(2)))
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
                .id(UUID.randomUUID())
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
                .id(UUID.randomUUID())
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
