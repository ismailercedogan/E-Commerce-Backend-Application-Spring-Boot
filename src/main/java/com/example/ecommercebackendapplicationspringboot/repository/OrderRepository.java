package com.example.ecommercebackendapplicationspringboot.repository;

import com.example.ecommercebackendapplicationspringboot.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}

