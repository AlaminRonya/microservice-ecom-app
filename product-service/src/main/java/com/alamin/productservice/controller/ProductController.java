package com.alamin.productservice.controller;

import com.alamin.productservice.dto.request.RequestProductDTO;
import com.alamin.productservice.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/product")
    public ResponseEntity<?> add(@RequestBody RequestProductDTO dto){
        productService.add(dto);
        return new ResponseEntity<>("Add Product", HttpStatus.CREATED);
    }
    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
}
