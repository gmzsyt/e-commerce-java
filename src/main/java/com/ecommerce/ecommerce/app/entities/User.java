package com.ecommerce.ecommerce.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    Long Id;
    String userName;
    String password;
    String email;

}
