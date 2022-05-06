package org.patika.fourthweekhomeworkbatuhanunverdi.service;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.converter.OrderConverter;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateOrderDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Order;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.OrderRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mert Batuhan UNVERDI
 * @since 4.05.2022
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    @Override
    public void create(CreateOrderDTO createOrderDTO) {
        Order order = orderConverter.toOrder(createOrderDTO);
        orderRepository.save(order);
    }
}
