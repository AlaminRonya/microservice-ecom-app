package com.alamin.productservice.mapper;

import com.alamin.productservice.dto.request.RequestProductDTO;
import com.alamin.productservice.dto.response.ResponseProductDTO;
import com.alamin.productservice.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class ResponseProductDTOMapper implements Function<Product, ResponseProductDTO> {
    private final ResponseAttachmentDTOMapper mapper;
    @Override
    public ResponseProductDTO apply(Product product) {
        return new ResponseProductDTO(
                product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getDeletedAt(),product.getCreatedAt(), product.getUpdatedAt(),
                product.getProductAttachmentList().stream().map(mapper).toList()
        );
    }
}
