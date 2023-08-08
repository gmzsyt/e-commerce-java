package com.ecommerce.ecommerce.app.services;

import com.ecommerce.ecommerce.app.entities.Cart;
import com.ecommerce.ecommerce.app.entities.CartItem;
import com.ecommerce.ecommerce.app.entities.Product;
import com.ecommerce.ecommerce.app.entities.User;
import com.ecommerce.ecommerce.app.repository.CartItemRepository;
import com.ecommerce.ecommerce.app.requests.CartItemCreateRequest;
import com.ecommerce.ecommerce.app.requests.CartItemUpdateRequest;

import java.util.List;
import java.util.Optional;

public class CartItemService {
    private CartItemRepository cartItemRepository;
    private CartService cartService;
    private ProductService productService;

    public CartItemService(CartItemRepository cartItemRepository,ProductService productService,CartService cartService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    public List<CartItem> getAllCartItemsWithParam(Optional<Long> userId, Optional<Long> cartId) {
        if (userId.isPresent()&& cartId.isPresent()){
            return cartItemRepository.findByUserIdAndCartId(userId.get(),cartId.get());
        }else if(userId.isPresent()){
            return cartItemRepository.findByUserId(userId.get());}
        else if (cartId.isPresent()) {
            return cartItemRepository.findByCartId(cartId.get());
        }
        else
            return cartItemRepository.findAll();
    }

    public CartItem getOneCartItem(Long cartId) {
        return cartItemRepository.findById(cartId).orElse(null);
    }

    public CartItem createOneCartItem(CartItemCreateRequest cartItemCreateRequest) {
        Cart cart = cartService.getOneCartById(cartItemCreateRequest.getCartId());
        Product product = productService.getOneProductById(cartItemCreateRequest.getProductId());
        if (cart != null && product != null){
            CartItem cartItemToSave = new CartItem();
            cartItemToSave.setId(cartItemCreateRequest.getId());
            cartItemToSave.setCart(cart);
            cartItemToSave.setProduct(product);
            cartItemToSave.setQuantity(cartItemCreateRequest.getQuantity());
            return cartItemRepository.save(cartItemToSave);
        }
        else
            return null;
    }


    public CartItem updateOneCartItem(Long cartItemId, CartItemUpdateRequest cartItemUpdateRequest) {
        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);
        if (cartItem.isPresent()){
            CartItem cartItemToUpdate = cartItem.get();
            cartItemToUpdate.setQuantity(cartItemUpdateRequest.getQuantity());
            return cartItemRepository.save(cartItemToUpdate);
        }
        else
            return null;
    }

    public void deleteOneCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
