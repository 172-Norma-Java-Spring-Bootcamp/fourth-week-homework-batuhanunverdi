package org.patika.fourthweekhomeworkbatuhanunverdi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
@Entity
@Getter
@Setter
public class CustomerAddress extends BaseModel {
    @Column(unique = true)
    private String phoneNumber;
    private String country;
    private String city;
    private String postalCode;
    private String description;
    @OneToOne
    private Customer customer;

}
