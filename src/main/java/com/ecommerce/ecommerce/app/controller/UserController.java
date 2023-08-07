package com.ecommerce.ecommerce.app.controller;

import com.ecommerce.ecommerce.app.entities.User;
import com.ecommerce.ecommerce.app.repository.UserRepository;
import com.ecommerce.ecommerce.app.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){   //constructor injection
        this.userService=userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();}
    @PostMapping
    public User createUser(@RequestBody User newuser){
        return  userService.saveOneUser(newuser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userService.getOneUser(userId);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        return userService.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }
}
