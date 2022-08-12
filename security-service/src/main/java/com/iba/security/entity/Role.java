package com.iba.security.entity;

import com.iba.library.entity.BasicIDEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Role extends BasicIDEntity {

    @Column(unique = true)
    private String name;

}
