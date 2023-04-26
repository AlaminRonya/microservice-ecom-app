package com.alamin.productservice.mapper;

import com.alamin.productservice.dto.request.RequestProductDTO;
import com.alamin.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class RequestProductDTOMapper implements Function<RequestProductDTO, Product> {
    @Override
    public Product apply(RequestProductDTO dto) {

        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .deletedAt(dto.deletedAt())
                .build();
    }
}
