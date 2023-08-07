package com.ecommerce.ecommerce.app.repository;

import com.ecommerce.ecommerce.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
