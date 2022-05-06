package org.patika.fourthweekhomeworkbatuhanunverdi.controller;

import lombok.RequiredArgsConstructor;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.CreateBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.dto.GetBasketItemDTO;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.BasketItemService;
import org.patika.fourthweekhomeworkbatuhanunverdi.service.BasketService;
import org.patika.fourthweekhomeworkbatuhanunverdi.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Mert Batuhan UNVERDI
 * @since 30.04.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/basket")
public class BasketController {
    private final BasketService basketService;
    private final BasketItemService basketItemService;
    private final Validator<CreateBasketItemDTO> basketItemValidator;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBasketDTO createBasketDTO){
        basketService.create(createBasketDTO);
        return  ResponseEntity.ok().build();
    }

    @PostMapping("/addItem")
    public ResponseEntity<?> create(@RequestBody CreateBasketItemDTO createBasketItemDTO){
        basketItemValidator.validate(createBasketItemDTO);
        basketItemService.create(createBasketItemDTO);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Collection<GetBasketItemDTO>> getBasket(@PathVariable Long id){
        return ResponseEntity.ok(basketItemService.getBasketItems(id));
    }
}
