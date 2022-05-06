package org.patika.fourthweekhomeworkbatuhanunverdi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.converter.BasketConverter;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BusinessServiceOperationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Basket;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Customer;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.BasketRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.CustomerRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.BasketService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Mert Batuhan UNVERDI
 * @since 30.04.2022
 */
@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketConverter basketConverter;
    private final CustomerRepository customerRepository;

    private static final BigDecimal SHIPPING_PRICE = BigDecimal.valueOf(50);
    @Override
    public void create(CreateBasketDTO createBasketDTO) {
        Customer customer = customerRepository.getById(createBasketDTO.getCustomer());
        Basket basket = basketConverter.toBasket(createBasketDTO);
        basket.setCustomer(customer);
        basket.setPrice(BigDecimal.ZERO);
        basket.setTotalPrice(BigDecimal.ZERO);
        basket.setShippingPrice(SHIPPING_PRICE);
        basketRepository.save(basket);
    }

    @Override
    public Basket getBasket(Long id) {
        return basketRepository.findById(id).orElseThrow(() -> new BusinessServiceOperationException.BasketNotFoundException("Basket Not Found"));
    }
}
