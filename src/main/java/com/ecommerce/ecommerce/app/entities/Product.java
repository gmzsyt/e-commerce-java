package com.ecommerce.ecommerce.app.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    Long id;
    String name;
    double price;
    @Lob
    @Column(columnDefinition = "text") //hibernatein varchar değil string alması için
    String description;
}
