package com.ecommerce.ecommerce.app.services;

import com.ecommerce.ecommerce.app.entities.Cart;
import com.ecommerce.ecommerce.app.entities.Order;
import com.ecommerce.ecommerce.app.entities.User;
import com.ecommerce.ecommerce.app.repository.CartRepository;
import com.ecommerce.ecommerce.app.requests.CartCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;
    private UserService userService;

    public CartService(CartRepository cartRepository,UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    public List<Cart> getAllCarts(Optional<Long> userId) {
        if (userId.isPresent()) return cartRepository.findByUserId(userId.get());
        return cartRepository.findAll();
    }

    public Cart createOneCart(CartCreateRequest newCartRequest) {
        User user =userService.getOneUser(newCartRequest.getUserId());
        if (user==null) return null;
        Cart toSave = new Cart();
        toSave.setId(newCartRequest.getId());
        toSave.setUser(user);
        return cartRepository.save(toSave);
    }


    public Cart updateOneCartId(Long cartId, Long cartId1) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()){
            Cart toUpdate = cart.get();
            toUpdate.setId(toUpdate.getId()); // normalde id disindakilere bunu yapmak lazımdı 
        }return null;
    }


    public void deleteOneCartById(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
