package com.iba.mainprocessor.entity;

import com.iba.library.entity.BasicIDEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BasicIDEntity {

    @Column(unique = true)
    private String name;

    private String description;

    // Using string due to opportunity to add some categories which will cause to changing of the position of all elements
    @Enumerated(EnumType.STRING)
    private Category category = Category.ANY;

}
