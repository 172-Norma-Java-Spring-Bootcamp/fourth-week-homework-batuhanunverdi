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
public class Category extends BaseModel {
    @OneToOne(cascade = CascadeType.PERSIST,orphanRemoval = true)
    private Category parent;
    @Column(unique = true,nullable = false)
    private String name;
}
