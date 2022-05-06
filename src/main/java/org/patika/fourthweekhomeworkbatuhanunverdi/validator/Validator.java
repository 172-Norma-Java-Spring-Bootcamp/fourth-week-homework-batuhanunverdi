package org.patika.fourthweekhomeworkbatuhanunverdi.validator;

import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseValidationException;
import org.springframework.stereotype.Component;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Component
public interface Validator<T> {
    void validate(T input) throws BaseValidationException;
}
