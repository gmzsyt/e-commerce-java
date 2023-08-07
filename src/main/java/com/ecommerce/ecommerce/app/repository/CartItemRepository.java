package com.ecommerce.ecommerce.app.repository;

import com.ecommerce.ecommerce.app.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
