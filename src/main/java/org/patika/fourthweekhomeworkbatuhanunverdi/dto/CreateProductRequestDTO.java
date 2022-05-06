package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Data
@RequiredArgsConstructor
public final class CreateProductRequestDTO {
    private final String name;
    private final BigDecimal price;
    private final String image;
    private final Long brand;
    private final Long category;
    private final Integer stock;


}
