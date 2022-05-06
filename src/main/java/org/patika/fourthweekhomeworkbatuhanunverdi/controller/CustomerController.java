package org.patika.fourthweekhomeworkbatuhanunverdi.controller;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateCustomerRequestDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetCustomersResponseDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.CustomerService;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.CustomerIdValidator;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final Validator<CreateCustomerRequestDTO> createCustomerValidator;
    private final CustomerIdValidator customerIdValidator;
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCustomerRequestDTO customerDTO) {
        createCustomerValidator.validate(customerDTO);
        customerService.create(customerDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCustomerRequestDTO> getCustomer(@PathVariable Long id) {
        customerIdValidator.validate(id);
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping
    public ResponseEntity<Collection<GetCustomersResponseDTO>> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        customerIdValidator.validate(id);
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
