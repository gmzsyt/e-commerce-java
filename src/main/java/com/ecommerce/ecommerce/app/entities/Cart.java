package com.ecommerce.ecommerce.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "carts")
@Data
public class Cart {
    @Id
    Long id;
    @OneToOne(fetch = FetchType.LAZY) //orderı çektiğimde ilgili userı bana getirme
    @JoinColumn(name ="user_id",nullable = false) // user_id yerine yazdıgımı söyüyorum
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde siparişleri silinsin
    @JsonIgnore
    User user;
}

