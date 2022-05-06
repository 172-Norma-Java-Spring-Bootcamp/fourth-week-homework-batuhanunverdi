package org.patika.fourthweekhomeworkbatuhanunverdi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
@Entity
@Getter
@Setter
public class BasketItem extends BaseModel{
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Basket basket;
    @ManyToOne(optional = false)
    private Product product;
    @Column(nullable = false)
    private BigDecimal quantity;
    private BigDecimal price;

}
