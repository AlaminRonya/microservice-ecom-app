package com.alamin.inventoryservice.controller;

import com.alamin.inventoryservice.interfaces.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/inventory")
    public ResponseEntity<?> isInStock(@RequestParam List<String> skuCode){
        System.out.println(skuCode);
//        final boolean inStock = inventoryService.isInStock(skuCode);
        System.out.println("Inventory=====>");
        inventoryService.isInStock(skuCode).forEach(System.out::println);
        System.out.println("Inventory=====>");
        return new ResponseEntity<>(inventoryService.isInStock(skuCode), HttpStatus.OK);
    }

}
