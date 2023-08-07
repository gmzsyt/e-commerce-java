package com.ecommerce.ecommerce.app.repository;

import com.ecommerce.ecommerce.app.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByUserId(Long userId);
}

