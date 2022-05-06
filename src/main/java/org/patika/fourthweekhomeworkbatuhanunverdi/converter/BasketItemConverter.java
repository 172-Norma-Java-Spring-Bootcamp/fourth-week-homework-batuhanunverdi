package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.BasketItem;

/**
 * @author Mert Batuhan UNVERDI
 * @since 28.04.2022
 */
public interface BasketItemConverter {
    BasketItem toBasketItem(CreateBasketItemDTO createBasketItemDTO);
    GetBasketItemDTO toGetBasketItemsDTO(BasketItem basketItem);
}
