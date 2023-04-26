package com.alamin.orderservice.dto;

import java.util.List;

public record RequestOrderDTO(
        List<RequestOrderLineItemDTO> orderLineItemDTOS
) {
}
