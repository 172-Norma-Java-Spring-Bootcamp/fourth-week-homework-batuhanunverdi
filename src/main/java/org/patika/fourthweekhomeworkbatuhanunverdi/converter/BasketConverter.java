package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Basket;

/**
 * @author Mert Batuhan UNVERDI
 * @since 30.04.2022
 */
public interface BasketConverter {
    Basket toBasket(CreateBasketDTO createBasketDTO);
}
