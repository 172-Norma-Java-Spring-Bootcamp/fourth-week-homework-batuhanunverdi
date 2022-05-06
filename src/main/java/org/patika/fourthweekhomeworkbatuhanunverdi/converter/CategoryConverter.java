package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCategoryRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCategoryResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Category;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
public interface CategoryConverter {
    Category toCategory(CreateCategoryRequestDTO categoryDTO);
    CreateCategoryRequestDTO toCreateCategoryRequestDTO(Category category);
    GetCategoryResponseDTO toGetCategoryResponseDto(Category category);
}
