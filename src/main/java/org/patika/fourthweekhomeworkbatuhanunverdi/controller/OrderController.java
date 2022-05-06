package org.patika.fourthweekhomeworkbatuhanunverdi.controller;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateOrderDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mert Batuhan UNVERDI
 * @since 4.05.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateOrderDTO createOrderDTO){
        orderService.create(createOrderDTO);
        return ResponseEntity.ok().build();
    }

}
