package org.patika.fourthweekhomeworkbatuhanunverdi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */

@Data
@RequiredArgsConstructor
public final class CustomerAddressDTO {
    private final String phoneNumber;
    private final String country;
    private final String city;
    private final String postalCode;
    private final String description;
}
