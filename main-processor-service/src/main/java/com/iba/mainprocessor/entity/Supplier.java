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

@Entity
@Table(name = "suppliers")
@Setter
@Getter
@NoArgsConstructor
public class Supplier extends BasicIDEntity {

    @Column(unique = true)
    private String name;

    private String address;

    private String description;

    // Average customers rating for example or delete later
    private Double rating;

}
