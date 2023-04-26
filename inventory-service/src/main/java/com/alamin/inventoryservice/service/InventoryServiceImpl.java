package com.alamin.inventoryservice.service;

import com.alamin.inventoryservice.dto.InventoryResponse;
import com.alamin.inventoryservice.interfaces.InventoryService;
import com.alamin.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
//        inventoryRepository.findBySkuCodeIn(skuCode).isPresent();
//        return inventoryRepository.findBySkuCodeIn(skuCode).isPresent();

        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}
