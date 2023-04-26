package com.alamin.orderservice.dto;

import java.math.BigDecimal;

public record RequestOrderLineItemDTO(
        String skuCode,BigDecimal price,Integer quantity
) {
}
