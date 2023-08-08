package com.ecommerce.ecommerce.app.requests;

import lombok.Data;

@Data
public class CartItemCreateRequest {
    Long id;
    Long cartId;
    Long productId;
    int quantity;
}
