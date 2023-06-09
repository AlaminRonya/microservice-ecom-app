package com.alamin.inventoryservice.repository;

import com.alamin.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    Optional<Inventory> findBySkuCodeIn(String skuCode);
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
