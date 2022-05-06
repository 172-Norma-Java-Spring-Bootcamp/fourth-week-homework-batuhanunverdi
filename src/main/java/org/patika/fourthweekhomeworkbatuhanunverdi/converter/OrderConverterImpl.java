package org.patika.fourthweekhomeworkbatuhanunverdi.converter;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateOrderDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.exception.BusinessServiceOperationException;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Order;
import org.patika.fourthweekhomeworkbatuhanunverdi.model.Status;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.BasketRepository;
import org.patika.fourthweekhomeworkbatuhanunverdi.repoistory.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Mert Batuhan UNVERDI
 * @since 4.05.2022
 */
@Component
@RequiredArgsConstructor
public class OrderConverterImpl implements OrderConverter {
    private final CustomerRepository customerRepository;
    private final BasketRepository basketRepository;
    @Override
    public Order toOrder(CreateOrderDTO orderDTO) {
        if(customerRepository.findById(orderDTO.getCustomer()).isEmpty()){
            throw new BusinessServiceOperationException.CustomerNotFoundException("Customer not found");
        }
        if(basketRepository.findById(orderDTO.getBasket()).isEmpty()){
            throw new BusinessServiceOperationException.BasketNotFoundException("Basket not found");
        }
        if(!basketRepository.getById(orderDTO.getBasket()).getCustomer().getId().equals(orderDTO.getCustomer())){
            throw new BusinessServiceOperationException.BasketNotFoundException("This basket is not belong to this customer");
        }
        Order order = new Order();
        order.setCustomer(customerRepository.getById(orderDTO.getCustomer()));
        order.setBasket(basketRepository.getById(orderDTO.getBasket()));
        order.setOrderedDate(new Date());
        order.setStatus(Status.NEW);
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        return order;
    }
}
