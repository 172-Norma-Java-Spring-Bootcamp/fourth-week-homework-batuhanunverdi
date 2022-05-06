package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Basket;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.CustomerRepository;
import org.springframework.stereotype.Component;

/**
 * @author Mert Batuhan UNVERDI
 * @since 30.04.2022
 */
@Component
@RequiredArgsConstructor
public class BasketConverterImpl implements BasketConverter {
    private final CustomerRepository customerRepository;


    @Override
    public Basket toBasket(CreateBasketDTO createBasketDTO) {
        Basket basket = new Basket();
        basket.setCustomer(customerRepository.getById(createBasketDTO.getCustomer()));
        return basket;
    }
}
