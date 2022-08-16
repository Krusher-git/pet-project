package com.iba.mainprocessor.entity;

import com.iba.library.entity.BasicIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "concrete_products_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConcreteProductInfo extends BasicIDEntity {

    @ManyToOne
    @JoinColumn(name = "product_info_id")
    private ProductInfo productInfo;

    private Double price;

    private Integer selectedAmount;

//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;

}
