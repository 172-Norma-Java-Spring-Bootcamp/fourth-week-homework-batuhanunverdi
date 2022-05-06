package org.patika.fourthweekhomeworkbatuhanunverdi.service;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Basket;

/**
 * @author Mert Batuhan UNVERDI
 * @since 30.04.2022
 */
public interface BasketService {
    void create(CreateBasketDTO createBasketDTO);
    Basket getBasket(Long id);
}
