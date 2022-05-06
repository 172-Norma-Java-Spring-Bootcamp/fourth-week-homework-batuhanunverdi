package org.patika.fourthweekhomeworkbatuhanunverdi.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Brand;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Data
@RequiredArgsConstructor
public final class GetProductsResponseDTO {
    private final String name;
    private final BigDecimal price;
    private final String image;
    private final Brand brand;
}
