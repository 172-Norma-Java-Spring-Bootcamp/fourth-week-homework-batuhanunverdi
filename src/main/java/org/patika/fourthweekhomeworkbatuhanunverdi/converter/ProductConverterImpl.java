package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateProductRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetProductsResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Product;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.BrandRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Component
@RequiredArgsConstructor
public class ProductConverterImpl implements ProductConverter{
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Product toProduct(CreateProductRequestDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setBarcode(UUID.randomUUID());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setBrand(brandRepository.getById(productDTO.getBrand()));
        product.setCategory(categoryRepository.getById(productDTO.getCategory()));
        product.setCreatedAt(new Date());
        product.setCreatedBy("MertBatuhan");
        product.setStock(productDTO.getStock());
        return product;
    }

    @Override
    public CreateProductRequestDTO toCreateProductRequestDTO(Product product) {
       return new CreateProductRequestDTO(product.getName(),
               product.getPrice(),
               product.getImage(),
               product.getBrand().getId(),
               product.getCategory().getId(),
               product.getStock());
    }

    @Override
    public GetProductsResponseDTO toGetProductResponseDTO(Product product) {
        return new GetProductsResponseDTO(product.getName(),
                product.getPrice(),product.getImage(),product.getBrand());
    }
}
