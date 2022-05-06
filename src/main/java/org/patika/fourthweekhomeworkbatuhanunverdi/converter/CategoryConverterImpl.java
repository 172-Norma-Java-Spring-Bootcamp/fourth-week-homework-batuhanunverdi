package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCategoryRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCategoryResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Category;
import org.springframework.stereotype.Component;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@Component
public class CategoryConverterImpl implements CategoryConverter {

    @Override
    public Category toCategory(CreateCategoryRequestDTO categoryDTO) {
        Category category = new Category();
        category.setParent(categoryDTO.getParent());
        category.setName(categoryDTO.getName());
        return category;
    }

    @Override
    public CreateCategoryRequestDTO toCreateCategoryRequestDTO(Category category) {
        return new CreateCategoryRequestDTO(category.getParent(), category.getName());
    }

    @Override
    public GetCategoryResponseDTO toGetCategoryResponseDto(Category category) {
        return new GetCategoryResponseDTO(category.getName());
    }
}
