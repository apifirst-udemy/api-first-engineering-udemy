package com.rsouza01.apifirst_server.bootstrap;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.time.OffsetDateTime;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rsouza01.apifirst_server.domain.Order;
import com.rsouza01.apifirst_server.domain.OrderLine;
import com.rsouza01.apifirst_server.domain.OrderStatusEnum;
import com.rsouza01.apifirst_server.domain.PaymentMethod;
import com.rsouza01.apifirst_server.domain.Address;
import com.rsouza01.apifirst_server.domain.Category;
import com.rsouza01.apifirst_server.domain.Customer;
import com.rsouza01.apifirst_server.domain.Dimensions;
import com.rsouza01.apifirst_server.domain.Image;
import com.rsouza01.apifirst_server.domain.Name;
import com.rsouza01.apifirst_server.domain.Product;
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

    @Override
    public void run(String... args) throws Exception {

        // initAllRepositories(); <- ERROR HERE
        initAllRepositoriesSFG();
    }

    private void initAllRepositories() {
        initCustomerList();
        initCategoriesList();
        initProductList();
        initOrdersList();

        initCustomerRepository();
        initCategoriesRepository();
        initProductRepository();
        initOrderRepository();
    }

    private void initProductRepository() {
        productsList.forEach(product -> productRepository.save(product));
    }

    private void initCustomerRepository() {
        customersList.forEach(customer -> {
            Customer savedCustomer = customerRepository.saveAndFlush(customer);
            System.out.println(">>> initCustomerRepository.savedCustomer: " + savedCustomer.toString());

        });
    }

    private void initCategoriesRepository() {
        categoriesList.forEach(category -> categoryRepository.saveAndFlush(category));
    }

    private void initOrderRepository() {
        ordersList.forEach(order -> orderRepository.saveAndFlush(order));
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

    private void initOrdersList() {
        Order order1 = Order.builder()
                .customer(customersList.get(0))
                .selectedPaymentMethod(customersList.get(0).getPaymentMethods().get(0))
                .orderStatus(OrderStatusEnum.NEW)
                .shipmentInfo("shipment info")
                .orderLines(List.of(
                        OrderLine.builder()
                                .product(productsList.get(0))
                                .orderQuantity(1)
                                .shipQuantity(10)
                                .build(),
                        OrderLine.builder()
                                .product(productsList.get(1))
                                .orderQuantity(1)
                                .shipQuantity(10)
                                .build()))
                .build();

        ordersList.add(order1);

        Order order2 = Order.builder()
                .customer(customersList.get(1))
                .selectedPaymentMethod(customersList.get(1).getPaymentMethods().get(0))
                .orderStatus(OrderStatusEnum.NEW)
                .shipmentInfo("shipment info")
                .orderLines(List.of(OrderLine.builder()
                        .product(productsList.get(0))
                        .orderQuantity(1)
                        .shipQuantity(1)
                        .build(),
                        OrderLine.builder()
                                .product(productsList.get(1))
                                .orderQuantity(1)
                                .shipQuantity(1)
                                .build()))
                .build();
        ordersList.add(order2);

    }

    private void initProductList() {
        Product product1 = Product.builder()
                .description("Product 1")
                .price("123")
                .cost("100")
                .dimensions(Dimensions.builder().width(10).height(10).length(10).build())
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
                .dimensions(Dimensions.builder().width(100).height(100).length(100).build())
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
                        .firstName("Customer")
                        .lastName("Number1")
                        .build())
                .billToAddress(address1)
                .shipToAddress(address1)
                .email("customer1@api.first")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("Card 1")
                        .cvv(123)
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .build()))
                .build();

        Address address2 = Address.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
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
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("Card 2")
                        .cvv(123)
                        .cardNumber(1234888)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .build()))
                .build();

        System.out.println("customer1: " + customer1.toString());
        System.out.println("customer2: " + customer2.toString());

        customersList.add(customer1);
        customersList.add(customer2);
    }

    public void initAllRepositoriesSFG() {
        Category electronics = categoryRepository.save(Category.builder()
                .category("Electronics")
                .description("Electronics")
                .categoryCode("ELECTRONICS")
                .build());

        Category clothing = categoryRepository.save(Category.builder()
                .category("Clothing")
                .description("Clothing")
                .categoryCode("CLOTHING")
                .build());

        Category dryGoods = categoryRepository.save(Category.builder()
                .category("Dry Goods")
                .description("Dry Goods")
                .categoryCode("DRYGOODS")
                .build());

        Address address1 = Address.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
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
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("My Card")
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .cvv(123)
                        .build()))
                .build();

        Address address2 = Address.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
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
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("My Other Card")
                        .cardNumber(1234888)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .cvv(456)
                        .build()))
                .build();

        Customer savedCustomer1 = customerRepository.save(customer1);
        Customer savedCustomer2 = customerRepository.save(customer2);

        Product product1 = Product.builder()
                .description("Product 1")
                .categories(Arrays.asList(dryGoods))
                .cost("12.99")
                .price("14.99")
                .dimensions(Dimensions.builder()
                        .height(1)
                        .length(2)
                        .width(3)
                        .build())
                .images(List.of(Image.builder()
                        .url("http://example.com/image1")
                        .altText("Image 1")
                        .build()))
                .build();

        Product product2 = Product.builder()
                .description("Product 2")
                .categories(Arrays.asList(electronics))
                .cost("12.99")
                .price("14.99")
                .dimensions(Dimensions.builder()
                        .height(1)
                        .length(2)
                        .width(3)
                        .build())
                .images(List.of(Image.builder()
                        .url("http://example.com/image2")
                        .altText("Image 2")
                        .build()))
                .build();

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);

        Order order1 = Order.builder()
                .customer(savedCustomer1)
                .selectedPaymentMethod(savedCustomer1.getPaymentMethods().get(0))
                .orderStatus(OrderStatusEnum.NEW)
                .shipmentInfo("shipment info")
                .orderLines(List.of(OrderLine.builder()
                        .product(product1)
                        .orderQuantity(1)
                        .shipQuantity(1)
                        .build(),
                        OrderLine.builder()
                                .product(savedProduct1)
                                .orderQuantity(1)
                                .shipQuantity(1)
                                .build()))
                .build();

        Order order2 = Order.builder()
                .customer(savedCustomer2)
                .selectedPaymentMethod(savedCustomer2.getPaymentMethods().get(0))
                .orderStatus(OrderStatusEnum.NEW)
                .shipmentInfo("shipment info #2")
                .orderLines(List.of(OrderLine.builder()
                        .product(savedProduct2)
                        .orderQuantity(1)
                        .shipQuantity(1)
                        .build(),
                        OrderLine.builder()
                                .product(product2)
                                .orderQuantity(1)
                                .shipQuantity(1)
                                .build()))
                .build();

        orderRepository.save(order1);
        orderRepository.save(order2);
    }
}
