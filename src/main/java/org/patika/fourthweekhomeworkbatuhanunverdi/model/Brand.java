package org.patika.fourthweekhomeworkbatuhanunverdi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
@Getter
@Setter
@Entity
public class Brand extends BaseModel {
    @Column(unique = true)
    private String name;
    private String image;
}
