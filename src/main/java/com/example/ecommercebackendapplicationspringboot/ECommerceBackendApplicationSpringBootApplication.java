package com.example.ecommercebackendapplicationspringboot;

import com.example.ecommercebackendapplicationspringboot.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceBackendApplicationSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceBackendApplicationSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository, AddressRepository addressRepository, ShoppingCartRepository shoppingCartRepository, ItemRepository itemRepository) {
        return (args) -> {

        };
    }



}
