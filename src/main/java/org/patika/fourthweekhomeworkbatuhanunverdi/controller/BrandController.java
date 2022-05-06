package org.patika.fourthweekhomeworkbatuhanunverdi.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.BrandDTO;

import org.patika.fourthweekhomeworkbatuhanunverdi.service.BrandService;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.BrandIdValidator;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.CreateBrandRequestValidator;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 26.04.2022
 */
@RestController
@RequestMapping(value = "api/brands")
@RequiredArgsConstructor
public class BrandController {
    private  final Validator<BrandDTO> brandDTOValidator;
    private final BrandIdValidator brandIdValidator;
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
        brandDTOValidator.validate(brandDTO);
        brandService.create(brandDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrand(@PathVariable Long id){
        brandIdValidator.validate(id);
        return ResponseEntity.ok(brandService.getBrand(id));
    }

    @GetMapping
    public ResponseEntity<Collection<BrandDTO>> getBrands(){
        return ResponseEntity.ok(brandService.getBrands());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id ){
        brandIdValidator.validate(id);
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }
}
