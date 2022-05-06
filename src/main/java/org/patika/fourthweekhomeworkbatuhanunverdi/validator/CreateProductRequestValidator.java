package org.patika.fourthweekhomeworkbatuhanunverdi.validator;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateProductRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseValidationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.ValidationOperationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Component
public class CreateProductRequestValidator implements Validator<CreateProductRequestDTO> {
    @Override
    public void validate(CreateProductRequestDTO productDTO) throws BaseValidationException {

        if(Objects.isNull(productDTO)){
            throw new ValidationOperationException.ProductNotValidException("Product can not be null or empty");
        }
        if(!(StringUtils.hasLength(productDTO.getName()))){
            throw new ValidationOperationException.ProductNotValidException("Product name can not be null or empty");
        }
        if(Objects.isNull(productDTO.getBrand())){
            throw new ValidationOperationException.ProductNotValidException("Product Brand can not be null or empty");
        }
        if(Objects.isNull(productDTO.getCategory())){
            throw new ValidationOperationException.ProductNotValidException("Product Category can not be null or empty");
        }
        if(!(StringUtils.hasLength(productDTO.getImage()))){
            throw new ValidationOperationException.ProductNotValidException("Product image can not be null or empty");
        }
        if(productDTO.getPrice().intValueExact()<0){
            throw new ValidationOperationException.ProductNotValidException("Product price can not be negative");
        }
        if(productDTO.getBrand().intValue()<0){
            throw new ValidationOperationException.BrandNotValidException("Brand id can not be negative");
        }
        if(productDTO.getCategory().intValue()<0){
            throw new ValidationOperationException.CategoryNotValidException("Category id can not be negative");
        }

    }
}
