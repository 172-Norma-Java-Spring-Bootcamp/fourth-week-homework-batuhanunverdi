package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 28.04.2022
 */
@Data
@RequiredArgsConstructor
public final class CreateBasketItemDTO {
    private final Long basket;
    private final Long product;
    private final BigDecimal quantity;

}
