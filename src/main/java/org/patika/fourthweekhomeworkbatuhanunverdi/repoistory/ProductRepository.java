package org.patika.fourthweekhomeworkbatuhanunverdi.repoistory;

import org.patika.fourthweekhomeworkbatuhanunverdi.model.Brand;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Category;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 24.04.2022
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Collection<Product> findProductByIsDeleted(boolean isDeleted);
    void deleteAllByCategory(Category category);
    void deleteAllByBrand(Brand brand);
    Product getProductByName(String name);
}
