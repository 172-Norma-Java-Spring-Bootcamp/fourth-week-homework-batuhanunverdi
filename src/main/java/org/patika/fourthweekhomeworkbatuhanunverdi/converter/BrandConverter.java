package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.BrandDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Brand;

/**
 * @author Mert Batuhan UNVERDI
 * @since 26.04.2022
 */
public interface BrandConverter {
    Brand toBrand(BrandDTO brandDTO);
    BrandDTO toBrandDTO(Brand brand);
}
