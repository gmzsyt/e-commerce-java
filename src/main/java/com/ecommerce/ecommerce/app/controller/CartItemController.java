package com.ecommerce.ecommerce.app.controller;

import com.ecommerce.ecommerce.app.entities.CartItem;
import com.ecommerce.ecommerce.app.entities.User;
import com.ecommerce.ecommerce.app.requests.CartCreateRequest;
import com.ecommerce.ecommerce.app.requests.CartItemCreateRequest;
import com.ecommerce.ecommerce.app.requests.CartItemUpdateRequest;
import com.ecommerce.ecommerce.app.services.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartItems")
public class CartItemController {
    private CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }
    @GetMapping
    public List<CartItem> getAllCartItems(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> cartId){
        return cartItemService.getAllCartItemsWithParam(userId,cartId);
    }

    @GetMapping ("/{cartItemId}")
    public CartItem getOneCartItem(@PathVariable Long cartId){
        return cartItemService.getOneCartItem(cartId);
    }

    @PostMapping
    public CartItem createOneCartItem(@RequestBody CartItemCreateRequest cartItemCreateRequest){
        return cartItemService.createOneCartItem(cartItemCreateRequest);
    }
    @PutMapping("/{CartItemId}")
    public CartItem updateOneUser(@PathVariable Long cartItemId, @RequestBody CartItemUpdateRequest cartItemUpdateRequest){
        return cartItemService.updateOneCartItem(cartItemId,cartItemUpdateRequest);
    }
    @DeleteMapping
    public void deleteOneCartItem(@PathVariable Long cartItemId){
        cartItemService.deleteOneCartItem(cartItemId);
    }

}
