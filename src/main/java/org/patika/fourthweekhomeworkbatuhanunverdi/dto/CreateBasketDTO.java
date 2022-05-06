package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Mert Batuhan UNVERDI
 * @since 30.04.2022
 */
@Data
@RequiredArgsConstructor
public final class CreateBasketDTO {
    private final Long customer;
    private final BigDecimal discountRate;
}
