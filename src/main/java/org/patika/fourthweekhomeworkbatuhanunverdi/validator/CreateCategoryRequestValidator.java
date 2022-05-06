package org.patika.fourthweekhomeworkbatuhanunverdi.validator;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCategoryRequestDTO;
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
public class CreateCategoryRequestValidator implements Validator<CreateCategoryRequestDTO> {
    @Override
    public void validate(CreateCategoryRequestDTO categoryDTO) throws BaseValidationException {
        if(Objects.isNull(categoryDTO)){
            throw new ValidationOperationException.CategoryNotValidException("Category can not be null or empty");
        }
        if(!StringUtils.hasLength(categoryDTO.getName()) || categoryDTO.getName().isBlank()){
            throw new ValidationOperationException.CategoryNotValidException("Category name can not be null or empty");
        }

    }
}
