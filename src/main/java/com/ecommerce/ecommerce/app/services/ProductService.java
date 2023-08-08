package com.ecommerce.ecommerce.app.services;

import com.ecommerce.ecommerce.app.entities.Product;
import com.ecommerce.ecommerce.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createOneProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }


    public Product getOneProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product updateOneProduct(Long productId, Product newProduct) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
            Product foundProduct = product.get();
            foundProduct.setName(newProduct.getName());
            foundProduct.setDescription(newProduct.getDescription());
            foundProduct.setPrice(newProduct.getPrice());
            productRepository.save(foundProduct);
            return foundProduct;
        }
        else return null;
    }

    public void deleteById(Long productId) {
      productRepository.deleteById(productId);
    }
}
