package com.ecommerce.ecommerce.app.repository;

import com.ecommerce.ecommerce.app.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByUserIdAndCartId(Long userId, Long cartId);

    List<CartItem> findByUserId(Long userId);

    List<CartItem> findByCartId(Long cartId);
}
