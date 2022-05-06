package org.patika.fourthweekhomeworkbatuhanunverdi.repoistory;

import org.patika.fourthweekhomeworkbatuhanunverdi.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 25.04.2022
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand getBrandByName(String name);

}
