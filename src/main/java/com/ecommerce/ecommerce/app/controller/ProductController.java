package com.ecommerce.ecommerce.app.controller;

import com.ecommerce.ecommerce.app.entities.Product;
import com.ecommerce.ecommerce.app.entities.User;
import com.ecommerce.ecommerce.app.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();}

    @PostMapping
    public Product createOneProduct(@RequestBody Product newProduct){
        return productService.createOneProduct(newProduct);
    }
    @GetMapping("/{userId}")
    public Product getOneProduct(@PathVariable Long productId){
        return productService.getOneUser(productId);
    }
    @PutMapping("/{userId}")
    public Product updateOneProduct(@PathVariable Long productId,@RequestBody Product newProduct){
        return productService.updateOneProduct(productId,newProduct);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneProduct(@PathVariable Long productId){
        productService.deleteById(productId);
    }

}
