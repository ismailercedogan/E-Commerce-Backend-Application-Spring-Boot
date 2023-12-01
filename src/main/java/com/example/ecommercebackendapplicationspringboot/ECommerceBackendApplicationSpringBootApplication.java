package com.example.ecommercebackendapplicationspringboot;

import com.example.ecommercebackendapplicationspringboot.repository.*;
import com.example.ecommercebackendapplicationspringboot.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class ECommerceBackendApplicationSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceBackendApplicationSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository, AddressRepository addressRepository, ShoppingCartRepository shoppingCartRepository, ItemRepository itemRepository) {
        return (args) -> {
                    // Create initial users
                    User user1 = new User();
                    user1.setUsername("user1");
                    user1.setEmail("user1@example.com");
                    user1 = userRepository.save(user1);

                    User user2 = new User();
                    user2.setUsername("user2");
                    user2.setEmail("user2@example.com");
                    user2 = userRepository.save(user2);

                    // Create initial products
                    Product product1 = new Product();
                    product1.setName("Product 1");
                    product1.setDescription("Description for Product 1");
                    product1.setPrice(10.0);
                    product1 = productRepository.save(product1);

                    Product product2 = new Product();
                    product2.setName("Product 2");
                    product2.setDescription("Description for Product 2");
                    product2.setPrice(20.0);
                    product2 = productRepository.save(product2);

                    // Create initial shopping carts and associate them with users
                    ShoppingCart shoppingCart1 = new ShoppingCart();
                    shoppingCart1.setUser(user1);
                    shoppingCart1 = shoppingCartRepository.save(shoppingCart1);

                    ShoppingCart shoppingCart2 = new ShoppingCart();
                    shoppingCart2.setUser(user2);
                    shoppingCart2 = shoppingCartRepository.save(shoppingCart2);

                    // Create initial items and associate them with shopping carts and products
                    Item item1 = new Item();
                    item1.setProduct(product1);
                    item1.setQuantity(1);
                    item1.setShoppingCart(shoppingCart1);
                    item1 = itemRepository.save(item1);

                    Item item2 = new Item();
                    item2.setProduct(product2);
                    item2.setQuantity(2);
                    item2.setShoppingCart(shoppingCart2);
                    item2 = itemRepository.save(item2);

                    // Create initial orders, associate them with users and addresses, and add products to them
                    Order order1 = new Order();
                    order1.setUser(user1);
                    order1.setTotalAmount(new BigDecimal(10));
                    order1.setProducts(Arrays.asList(product1));
                    order1 = orderRepository.save(order1);

                    Order order2 = new Order();
                    order2.setUser(user2);
                    order2.setTotalAmount(new BigDecimal(40));
                    order2.setProducts(Arrays.asList(product1, product2));
                    order2 = orderRepository.save(order2);

                    // Create initial addresses and associate them with orders
                    Address address1 = new Address();
                    address1.setStreet("Street 1");
                    address1.setCity("City 1");
                    address1.setState("State 1");
                    address1.setZip("Zip 1");
                    address1.setOrders(Arrays.asList(order1));
                    address1 = addressRepository.save(address1);

                    Address address2 = new Address();
                    address2.setStreet("Street 2");
                    address2.setCity("City 2");
                    address2.setState("State 2");
                    address2.setZip("Zip 2");
                    address2.setOrders(Arrays.asList(order2));
                    address2 = addressRepository.save(address2);
                };
            }


        };

