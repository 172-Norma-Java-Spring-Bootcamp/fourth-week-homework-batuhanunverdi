package org.patika.fourthweekhomeworkbatuhanunverdi.service;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.BrandDTO;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
public interface BrandService {
    void create(BrandDTO brandDTO);
    BrandDTO getBrand(Long id);
    Collection<BrandDTO> getBrands();
    void delete(Long id);
}
