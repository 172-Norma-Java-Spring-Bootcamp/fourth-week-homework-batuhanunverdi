package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.BasketItem;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.BasketRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.ProductRepository;
import org.springframework.stereotype.Component;

/**
 * @author Mert Batuhan UNVERDI
 * @since 28.04.2022
 */
@Component
@RequiredArgsConstructor
public class BasketItemConverterImpl implements BasketItemConverter {
    private final ProductRepository productRepository;
    private final BasketRepository basketRepository;

    @Override
    public BasketItem toBasketItem(CreateBasketItemDTO createBasketItemDTO) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProduct(productRepository.getById(createBasketItemDTO.getProduct()));
        basketItem.setBasket(basketRepository.getById(createBasketItemDTO.getBasket()));
        basketItem.setQuantity(createBasketItemDTO.getQuantity());
        basketItem.setPrice(basketItem.getProduct().getPrice().multiply(basketItem.getQuantity()));
        return basketItem;
    }

    public GetBasketItemDTO toGetBasketItemsDTO(BasketItem basketItem){
        return new GetBasketItemDTO(basketItem.getProduct(),basketItem.getQuantity());
    }

}
