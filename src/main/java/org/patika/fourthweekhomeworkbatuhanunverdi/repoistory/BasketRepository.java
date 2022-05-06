package org.patika.fourthweekhomeworkbatuhanunverdi.repoistory;

import org.patika.fourthweekhomeworkbatuhanunverdi.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mert Batuhan UNVERDI
 * @since 30.04.2022
 */
@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
}
