package com.ecommerce.ecommerce.app.controller;

import com.ecommerce.ecommerce.app.entities.Cart;
import com.ecommerce.ecommerce.app.entities.Order;
import com.ecommerce.ecommerce.app.requests.CartCreateRequest;
import com.ecommerce.ecommerce.app.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getAllCarts(@RequestParam Optional<Long> userId){
        return cartService.getAllCarts(userId);
    }

    @PostMapping
    public Cart createOneCart(@RequestBody CartCreateRequest newCartRequest) {
        return cartService.createOneCart(newCartRequest);
    }

    @PutMapping
    public Cart updateOneCart(@PathVariable Long cartId, @RequestBody Cart updateCart){
        return cartService.updateOneCartId(cartId,cartId);
    }

    @DeleteMapping("/{postId}")
    public void deleteOneCartById(@PathVariable Long cartId){
         cartService.deleteOneCartById(cartId);
    }
}
