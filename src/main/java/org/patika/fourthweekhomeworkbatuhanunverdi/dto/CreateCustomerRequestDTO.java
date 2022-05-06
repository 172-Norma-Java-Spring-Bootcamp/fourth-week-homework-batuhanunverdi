package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Gender;


import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
@Data
@RequiredArgsConstructor
public final class CreateCustomerRequestDTO {
    private final String username;
    private final String email;
    private final Long identity;
    private final Gender gender;
    private final String password;
    private final CustomerAddressDTO customerAddress;


}
