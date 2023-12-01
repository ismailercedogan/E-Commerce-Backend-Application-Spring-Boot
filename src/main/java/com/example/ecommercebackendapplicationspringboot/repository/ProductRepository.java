package com.example.ecommercebackendapplicationspringboot.repository;

import com.example.ecommercebackendapplicationspringboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

