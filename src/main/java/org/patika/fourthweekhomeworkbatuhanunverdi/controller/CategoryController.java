package org.patika.fourthweekhomeworkbatuhanunverdi.controller;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCategoryRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCategoryResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.CategoryService;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.CategoryIdValidator;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {

    private final Validator<CreateCategoryRequestDTO> createCategoryRequestDTOValidator;
    private final CategoryIdValidator categoryIdValidator;
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
        createCategoryRequestDTOValidator.validate(createCategoryRequestDTO);
        categoryService.create(createCategoryRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCategoryRequestDTO> getCategory(@PathVariable Long id){
        categoryIdValidator.validate(id);
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @GetMapping
    public ResponseEntity<Collection<GetCategoryResponseDTO>> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryIdValidator.validate(id);
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
