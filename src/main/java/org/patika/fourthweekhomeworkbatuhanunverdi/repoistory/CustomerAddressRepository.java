package org.patika.fourthweekhomeworkbatuhanunverdi.repoistory;

import org.patika.fourthweekhomeworkbatuhanunverdi.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mert Batuhan UNVERDI
 * @since 27.04.2022
 */
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {
    CustomerAddress getCustomerAddressByPhoneNumber(String phoneNumber);
}
