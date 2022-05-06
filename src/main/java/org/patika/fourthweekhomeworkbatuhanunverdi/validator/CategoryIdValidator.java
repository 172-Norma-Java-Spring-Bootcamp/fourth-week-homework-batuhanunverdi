package org.patika.fourthweekhomeworkbatuhanunverdi.validator;

import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseValidationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BusinessServiceOperationException;
import org.springframework.stereotype.Component;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@Component
public class CategoryIdValidator implements Validator<Long>{
    @Override
    public void validate(Long input) throws BaseValidationException {
        if(input<0){
            throw new BusinessServiceOperationException.CategoryNotFoundException("Category not found");
        }

    }
}
