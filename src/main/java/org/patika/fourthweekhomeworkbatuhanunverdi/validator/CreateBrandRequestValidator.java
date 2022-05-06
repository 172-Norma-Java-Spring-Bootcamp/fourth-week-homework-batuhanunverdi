package org.patika.fourthweekhomeworkbatuhanunverdi.validator;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.BrandDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseValidationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.ValidationOperationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@Component
public class CreateBrandRequestValidator implements Validator<BrandDTO>{
    @Override
    public void validate(BrandDTO brandDTO) throws BaseValidationException {
        if(Objects.isNull(brandDTO)){
            throw new ValidationOperationException.BrandNotValidException("Brand can not be null or empty");
        }
        if(!(StringUtils.hasLength(brandDTO.getName()))|| brandDTO.getName().isBlank()){
            throw new ValidationOperationException.BrandNotValidException("Brand name can not be null or empty");
        }
    }
}
