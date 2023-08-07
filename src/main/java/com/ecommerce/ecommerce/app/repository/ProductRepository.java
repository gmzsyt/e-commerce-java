package com.ecommerce.ecommerce.app.repository;

import com.ecommerce.ecommerce.app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
