package com.alamin.productservice.service;

import com.alamin.productservice.dto.Response;
import com.alamin.productservice.dto.request.RequestProductDTO;
import com.alamin.productservice.dto.response.ResponseProductDTO;
import com.alamin.productservice.interfaces.ProductService;
import com.alamin.productservice.mapper.RequestProductDTOMapper;
import com.alamin.productservice.mapper.ResponseProductDTOMapper;
import com.alamin.productservice.model.Product;
import com.alamin.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final RequestProductDTOMapper requestProductDTOMapper;
    private final ResponseProductDTOMapper responseProductDTOMapper;
    private final ProductRepository productRepository;
    @Override
    public void add(RequestProductDTO dto) {
        final Product product = requestProductDTOMapper.apply(dto);
        // TODO: 4/23/2023 Attachment no added and Exception handling
//        product.setProductAttachmentList(null);
        productRepository.save(product);
    }

    @Override
    public Response getAllProduct() {

        return Response.builder()
                .timeStamp(now())
                .data(Map.of("products",productRepository.findAll().stream().map(responseProductDTOMapper).toList()))
                .message("Success")
                .status(OK)
                .statusCode(OK.value())
                .build();
    }
}
