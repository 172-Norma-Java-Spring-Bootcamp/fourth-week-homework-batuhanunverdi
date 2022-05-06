package org.patika.fourthweekhomeworkbatuhanunverdi.repoistory;

import org.patika.fourthweekhomeworkbatuhanunverdi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Collection<Customer> findCustomersByIsDeleted(boolean isDeleted);
    Customer getCustomerByEmail(String email);
    Customer getCustomerByUsername(String email);
}
