package com.iba.mainprocessor.entity;


import com.iba.library.entity.BasicIDEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "wishlists")
public class Wishlist extends BasicIDEntity {

    @Column(name = "user_id", unique = true)
    private Long userId;

    @ManyToMany
    @JoinTable(name = "wishlist_proucts",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

}
