package org.patika.fourthweekhomeworkbatuhanunverdi.service;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateProductRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetProductsResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseException;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
public interface ProductService {

    void create(CreateProductRequestDTO productDTO);

    CreateProductRequestDTO getProduct(Long id) throws BaseException;

    Collection<GetProductsResponseDTO> getProducts();

    void delete(Long id) throws BaseException;

}
