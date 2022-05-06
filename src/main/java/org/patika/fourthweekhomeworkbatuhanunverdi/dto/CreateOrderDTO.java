package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Date;

/**
 * @author Mert Batuhan UNVERDI
 * @since 4.05.2022
 */
@Data
@RequiredArgsConstructor
public final class CreateOrderDTO {
    private final Long customer;
    private final Long basket;
    private final String paymentMethod;
}
