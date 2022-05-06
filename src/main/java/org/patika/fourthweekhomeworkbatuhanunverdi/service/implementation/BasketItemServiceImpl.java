package org.patika.fourthweekhomeworkbatuhanunverdi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.converter.BasketItemConverter;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BusinessServiceOperationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Basket;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.BasketItem;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Product;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.BasketItemRepository;

import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.BasketRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.ProductRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.BasketItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Mert Batuhan UNVERDI
 * @since 28.04.2022
 */
@RequiredArgsConstructor
@Service
@Transactional
public class BasketItemServiceImpl implements BasketItemService {
    private final BasketItemRepository basketItemRepository;
    private final BasketItemConverter basketItemConverter;
    private final ProductRepository productRepository;
    private final BasketRepository basketRepository;
    private static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.20);
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.08);

    @Override
    public void create(CreateBasketItemDTO createBasketItemDTO) {
        if(productRepository.findById(createBasketItemDTO.getProduct()).isEmpty()) {
            throw new BusinessServiceOperationException.ProductNotFoundException("Product not found");
        }
        if(basketRepository.findById(createBasketItemDTO.getBasket()).isEmpty()){
            throw new BusinessServiceOperationException.BasketNotFoundException("Basket not found");
        }
       BasketItem basketItem =  basketItemConverter.toBasketItem(createBasketItemDTO);
       Basket basket = basketRepository.getById(createBasketItemDTO.getBasket());
       Product product = productRepository.getById(createBasketItemDTO.getProduct());
       basketItemRepository.save(basketItem);
        BigDecimal newPrice = basket.getPrice().
                add(product.getPrice().multiply(basketItem.getQuantity()));
        basket.setPrice(newPrice);
        basket.setTaxPrice(basket.getTaxPrice().add(newPrice.multiply(TAX_RATE)));
        basket.setDiscountPrice(basket.getDiscountPrice().add(newPrice.multiply(DISCOUNT_RATE)));
        basket.setTotalPrice(basket.getPrice().
                add(basket.getShippingPrice()).
                add(basket.getTaxPrice()).
                subtract(basket.getDiscountPrice()));
        basketRepository.save(basket);
    }

    @Override
    public Collection<GetBasketItemDTO> getBasketItems(Long id) {
        return  basketItemRepository.findAllByBasketId(id)
                .stream()
                .map(basketItemConverter::toGetBasketItemsDTO)
                .collect(Collectors.toList());
    }
}
