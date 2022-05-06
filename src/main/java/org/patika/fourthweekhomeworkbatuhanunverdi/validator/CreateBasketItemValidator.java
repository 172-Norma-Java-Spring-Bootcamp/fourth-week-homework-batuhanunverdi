package org.patika.fourthweekhomeworkbatuhanunverdi.validator;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseValidationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.ValidationOperationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.BasketService;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 29.04.2022
 */
@Component
@RequiredArgsConstructor
public class CreateBasketItemValidator implements Validator<CreateBasketItemDTO> {
    private final ProductService productService;
    private final BasketService basketService;
    @Override
    public void validate(CreateBasketItemDTO createBasketItemDTO) throws BaseValidationException {
        if(Objects.isNull(createBasketItemDTO)){
            throw new ValidationOperationException.BasketItemNotValid("This item is not in any basket");
        }
        if(Objects.isNull(productService.getProduct(createBasketItemDTO.getProduct()))){
            throw new ValidationOperationException.BasketItemNotValid("Product not found");
        }
        if(Objects.isNull(basketService.getBasket(createBasketItemDTO.getBasket()))){
            throw new ValidationOperationException.BasketItemNotValid("Basket not found");
        }
        if(createBasketItemDTO.getQuantity().intValueExact()<0){
            throw new ValidationOperationException.BasketItemNotValid("Item Quantity must be greater than zero");
        }
    }
}
