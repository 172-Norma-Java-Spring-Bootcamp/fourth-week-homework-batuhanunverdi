package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Product;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 29.04.2022
 */
@Data
@RequiredArgsConstructor
public final class GetBasketItemDTO {
    private final Product product;
    private final BigDecimal quantity;

}
