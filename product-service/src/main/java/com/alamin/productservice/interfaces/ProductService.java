package com.alamin.productservice.interfaces;

import com.alamin.productservice.dto.Response;
import com.alamin.productservice.dto.request.RequestProductDTO;

import java.util.List;

public interface ProductService {
    void add(RequestProductDTO dto);
    Response getAllProduct();
}
