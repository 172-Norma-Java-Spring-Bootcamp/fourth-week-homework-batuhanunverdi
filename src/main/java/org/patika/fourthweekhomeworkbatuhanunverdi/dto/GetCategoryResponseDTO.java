package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@Data
@RequiredArgsConstructor
public final class GetCategoryResponseDTO {
    private final String name;
}
