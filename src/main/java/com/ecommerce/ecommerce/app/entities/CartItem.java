package com.ecommerce.ecommerce.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cartItems")
@Data
public class CartItem {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="cart_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //keajsflaskjrgh
    @JsonIgnore
    Cart cart;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="product_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Product product;
    int quantity; // ürün miktarı
}
