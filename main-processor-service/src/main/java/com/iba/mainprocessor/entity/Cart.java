package com.iba.mainprocessor.entity;

import com.iba.library.entity.BasicIDEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart extends BasicIDEntity {

    @Column(name = "user_id", unique = true)
    private Long userId;

    @OneToMany
    private Set<ProductInfo> products = new HashSet<>();

}
