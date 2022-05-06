package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateProductRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetProductsResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Product;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
public interface ProductConverter {

    Product toProduct(CreateProductRequestDTO productDTO);
    CreateProductRequestDTO toCreateProductRequestDTO(Product product);
    GetProductsResponseDTO toGetProductResponseDTO(Product product);
}
