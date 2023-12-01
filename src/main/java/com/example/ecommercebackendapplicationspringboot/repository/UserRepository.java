package com.example.ecommercebackendapplicationspringboot.repository;

import com.example.ecommercebackendapplicationspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);
}
