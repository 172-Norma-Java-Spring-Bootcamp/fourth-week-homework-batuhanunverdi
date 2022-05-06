package org.patika.fourthweekhomeworkbatuhanunverdi.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Gender;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Data
@RequiredArgsConstructor
public final class GetCustomersResponseDTO {
    private final String username;
    private final String email;
    private final Gender gender;
    private final CustomerAddressDTO address;


}
