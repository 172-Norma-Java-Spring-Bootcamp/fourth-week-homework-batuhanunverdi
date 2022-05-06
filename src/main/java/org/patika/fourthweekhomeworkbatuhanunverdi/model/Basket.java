package org.patika.fourthweekhomeworkbatuhanunverdi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */

@Entity
@Getter
@Setter
public class Basket extends BaseModel{
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    private BigDecimal price;
    private BigDecimal discountPrice = BigDecimal.ZERO;
    private BigDecimal taxPrice = BigDecimal.ZERO;
    private BigDecimal shippingPrice = BigDecimal.ZERO;
    private BigDecimal totalPrice;
    @OneToMany(mappedBy = "basket")
    private Collection<BasketItem> items = new HashSet<>();
    private Date createAt;
}
