package org.patika.fourthweekhomeworkbatuhanunverdi.service;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCategoryRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCategoryResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseException;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
public interface CategoryService {
    void create(CreateCategoryRequestDTO createCategoryRequestDTO);
    CreateCategoryRequestDTO getCategory(Long id) throws BaseException;
    Collection<GetCategoryResponseDTO> getCategories();
    void delete(Long id) throws BaseException;

}
