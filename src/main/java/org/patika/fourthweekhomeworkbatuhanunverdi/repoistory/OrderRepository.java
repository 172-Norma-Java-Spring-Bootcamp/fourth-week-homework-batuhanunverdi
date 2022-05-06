package org.patika.fourthweekhomeworkbatuhanunverdi.repoistory;

import org.patika.fourthweekhomeworkbatuhanunverdi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mert Batuhan UNVERDI
 * @since 4.05.2022
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
