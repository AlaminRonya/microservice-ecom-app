package com.alamin.orderservice.controller;

import com.alamin.orderservice.dto.RequestOrderDTO;
import com.alamin.orderservice.interfaces.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/order")
    public ResponseEntity<?> orderPlace(@RequestBody RequestOrderDTO dto){
        System.out.println(dto);
        orderService.placeOrder(dto);
        return new ResponseEntity<>("Order Place", HttpStatus.OK);
    }
}
