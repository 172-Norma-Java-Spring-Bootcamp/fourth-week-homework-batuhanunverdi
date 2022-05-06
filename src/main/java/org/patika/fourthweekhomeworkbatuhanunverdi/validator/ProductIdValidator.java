package org.patika.fourthweekhomeworkbatuhanunverdi.validator;

import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseValidationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.ValidationOperationException;
import org.springframework.stereotype.Component;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Component
public class ProductIdValidator implements Validator<Long> {

    @Override
    public void validate(Long input) throws BaseValidationException {
        if(input<0){
            throw new ValidationOperationException.ProductIDNotValidException("Product ID should be greater than zero.");

        }
    }
}
