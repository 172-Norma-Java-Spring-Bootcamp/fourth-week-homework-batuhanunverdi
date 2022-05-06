package org.patika.fourthweekhomeworkbatuhanunverdi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.converter.ProductConverter;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateProductRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetProductsResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseException;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BusinessServiceOperationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Product;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.BrandRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.CategoryRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.ProductRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductConverter productConverter;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    @Override
    public void create(CreateProductRequestDTO productDTO) {
        if(categoryRepository.findById(productDTO.getCategory()).isEmpty()){
            throw new BusinessServiceOperationException.CategoryNotFoundException("Category Not Found");
        }
        if(brandRepository.findById(productDTO.getBrand()).isEmpty()){
            throw new BusinessServiceOperationException.BrandNotFoundException("Brand Not Found");
        }
        if(productRepository.getProductByName(productDTO.getName())!=null){
            throw new BusinessServiceOperationException.ProductAlreadyHaveException("Product is already have in our system");
        }
        Product product = productConverter.toProduct(productDTO);
        product.setCategory(categoryRepository.getById(productDTO.getCategory()));
        product.setBrand(brandRepository.getById(productDTO.getBrand()));
        product.setBarcode(UUID.randomUUID());
        productRepository.save(product);
    }

    @Override
    public CreateProductRequestDTO getProduct(Long id) throws BaseException {
       Product product = productRepository.findById(id).orElseThrow(()
               -> new BusinessServiceOperationException.ProductNotFoundException("Product not found"));
       return productConverter.toCreateProductRequestDTO(product);
    }

    @Override
    public Collection<GetProductsResponseDTO> getProducts() {
        return productRepository.findProductByIsDeleted(false)
                .stream()
                .map(productConverter::toGetProductResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws BaseException {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new BusinessServiceOperationException.ProductNotFoundException("Product not found"));
        if(product.isDeleted()){
            throw new BusinessServiceOperationException.ProductAlreadyDeletedException("Product already deleted");
        }
        product.setDeleted(true);
        productRepository.save(product);
    }
}
