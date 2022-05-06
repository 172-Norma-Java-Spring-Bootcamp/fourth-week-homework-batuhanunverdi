package org.patika.fourthweekhomeworkbatuhanunverdi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
@Entity
@Getter
@Setter
public class Customer extends BaseExtendedModel{
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private Long identity;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String password;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerAddress customerAddress;
}
