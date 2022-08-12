package com.iba.mainprocessor.entity;

import com.iba.library.entity.BasicIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products_cost_and_suppliers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCostAndSupplier extends BasicIDEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "cost")
    private Double cost;

    private Integer amount;

}
