package org.patika.fourthweekhomeworkbatuhanunverdi.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.patika.fourthweekhomeworkbatuhanunverdi.converter.CustomerConverter;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCustomerRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCustomersResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BaseException;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BusinessServiceOperationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Customer;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.CustomerAddressRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.CustomerRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerConverter customerConverter;
    private final CustomerRepository customerRepository;
    private final CustomerAddressRepository customerAddressRepository;

    @Override
    public void create(CreateCustomerRequestDTO customerDTO) {
        Customer customer = customerConverter.toCustomer(customerDTO);
        if(customerRepository.getCustomerByUsername(customerDTO.getUsername())!=null){
            throw new BusinessServiceOperationException.CustomerAlreadyHaveException("This username is already registered in our system.");
        }
        if(customerRepository.getCustomerByEmail(customerDTO.getEmail())!=null){
            throw new BusinessServiceOperationException.CustomerAlreadyHaveException("This email is already registered in our system.");
        }
        if(customerAddressRepository.getCustomerAddressByPhoneNumber(customerDTO.getCustomerAddress().getPhoneNumber())!=null){
            throw new BusinessServiceOperationException.CustomerPhoneAlreadyHaveException("This Phone number is already registered in our system.");
        }
        customerRepository.save(customer);

    }

    @Override
    public CreateCustomerRequestDTO getCustomer(Long id) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new BusinessServiceOperationException.CustomerNotFoundException("Customer not found"));
        return customerConverter.toCreateCustomerRequestDTO(customer);
    }

    @Override
    public Collection<GetCustomersResponseDTO> getCustomers() {

        return  customerRepository.findCustomersByIsDeleted(false)
                .stream()
                .map(customerConverter::toGetCustomersResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws BaseException {
       Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new BusinessServiceOperationException.CustomerNotFoundException("Customer not found"));
        if(customer.isDeleted()){
            throw new BusinessServiceOperationException.CustomerAlreadyDeletedException("Customer already deleted");
        }
        customer.setDeleted(true);
        customerRepository.save(customer);
    }
}