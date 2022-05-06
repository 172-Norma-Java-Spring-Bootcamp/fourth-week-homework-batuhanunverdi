package org.patika.fourthweekhomeworkbatuhanunverdi.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 26.04.2022
 */
@Data
@RequiredArgsConstructor
public final class BrandDTO {
    private final String name;
    private final String image;
}
