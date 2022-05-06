package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCustomersResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Customer;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCustomerRequestDTO;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
public interface CustomerConverter {

    Customer toCustomer(CreateCustomerRequestDTO customerDTO);

    CreateCustomerRequestDTO toCreateCustomerRequestDTO(Customer customer);

    GetCustomersResponseDTO toGetCustomersResponseDto(Customer customer);
}
