package org.patika.fourthweekhomeworkbatuhanunverdi.controller;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateProductRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetProductsResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.ProductService;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.CreateProductRequestValidator;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.ProductIdValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {
    private final CreateProductRequestValidator createProductValidator;
    private final ProductIdValidator productIdValidator;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductRequestDTO productDTO){
        createProductValidator.validate(productDTO);
        productService.create(productDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateProductRequestDTO> getProduct(@PathVariable Long id){
        productIdValidator.validate(id);
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<Collection<GetProductsResponseDTO>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productIdValidator.validate(id);
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
