package com.alamin.orderservice.interfaces;

import com.alamin.orderservice.dto.RequestOrderDTO;

public interface OrderService {
    void placeOrder(RequestOrderDTO dto);
}
