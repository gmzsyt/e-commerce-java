package com.ecommerce.ecommerce.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY) //orderı çektiğimde ilgili userı bana getirme
    @JoinColumn(name ="user_id",nullable = false) // user_id yerine yazdıgımı söyüyorum
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde siparişleri silinsin
    @JsonIgnore
    User user;
    LocalDateTime orderDate;
}
