package org.patika.fourthweekhomeworkbatuhanunverdi.service;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetBasketItemDTO;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 28.04.2022
 */
public interface BasketItemService {
    void create(CreateBasketItemDTO basketItem);
    Collection<GetBasketItemDTO> getBasketItems(Long id);

}
