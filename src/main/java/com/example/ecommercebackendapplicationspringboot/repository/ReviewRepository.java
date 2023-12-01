package com.example.ecommercebackendapplicationspringboot.repository;

import com.example.ecommercebackendapplicationspringboot.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
