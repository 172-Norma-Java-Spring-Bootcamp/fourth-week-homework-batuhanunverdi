package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.BrandDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Brand;
import org.springframework.stereotype.Component;

/**
 * @author Mert Batuhan UNVERDI
 * @since 26.04.2022
 */
@Component
public class BrandConverterImpl implements BrandConverter {
    @Override
    public Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        brand.setImage(brandDTO.getImage());
        return brand;
    }

    @Override
    public BrandDTO toBrandDTO(Brand brand) {
        return new BrandDTO(brand.getName(), brand.getImage());
    }
}
