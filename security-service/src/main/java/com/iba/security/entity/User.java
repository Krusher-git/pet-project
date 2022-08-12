package com.iba.security.entity;

import com.iba.library.entity.BasicIDEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends BasicIDEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    //    Like in UserDetails(for security reasons)
    @Column(name = "is_user_non_locked")
    private Boolean isUserNonLocked = true;

    //    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role = new Role();

    //    for now they are zeroes in future may be feign clients or some new logic
    private Long cartId = 0L;

    private Long wishlistId = 0L;

}
