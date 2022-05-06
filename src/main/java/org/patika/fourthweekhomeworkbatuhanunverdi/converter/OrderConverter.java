package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateOrderDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Order;

/**
 * @author Mert Batuhan UNVERDI
 * @since 4.05.2022
 */
public interface OrderConverter {
    Order toOrder(CreateOrderDTO orderDTO);
}
