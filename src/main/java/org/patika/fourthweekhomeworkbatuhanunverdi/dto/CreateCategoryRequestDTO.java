package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Category;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@Data
@RequiredArgsConstructor
public final class CreateCategoryRequestDTO {
    private final Category parent;
    private final String name;



}
