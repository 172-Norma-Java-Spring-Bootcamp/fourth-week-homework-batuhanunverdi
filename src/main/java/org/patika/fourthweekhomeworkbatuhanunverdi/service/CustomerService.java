package org.patika.fourthweekhomeworkbatuhanunverdi.service;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCustomerRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCustomersResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseException;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
public interface CustomerService {
    void create(CreateCustomerRequestDTO customerDTO);

    CreateCustomerRequestDTO getCustomer(Long id) throws BaseException;

    Collection<GetCustomersResponseDTO> getCustomers();

    void delete(Long id) throws BaseException;

}
