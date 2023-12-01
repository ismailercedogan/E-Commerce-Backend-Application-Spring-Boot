package com.example.ecommercebackendapplicationspringboot.repository;

import com.example.ecommercebackendapplicationspringboot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
