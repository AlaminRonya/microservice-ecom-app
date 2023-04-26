package com.alamin.productservice.dto.request;


import java.math.BigDecimal;
import java.util.Date;

public record RequestProductDTO(
        String name,String description,BigDecimal price,Date deletedAt,Date createdAt,Date updatedAt
) {
}
