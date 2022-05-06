package org.patika.fourthweekhomeworkbatuhanunverdi.repoistory;

import org.patika.fourthweekhomeworkbatuhanunverdi.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 28.04.2022
 */
@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem,Long> {
    Collection<BasketItem> findAllByBasketId(Long id);

}
