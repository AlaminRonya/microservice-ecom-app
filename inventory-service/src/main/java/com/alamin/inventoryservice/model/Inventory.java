package com.alamin.inventoryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventory_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "sku_code")
    private String skuCode;
    private Integer quantity;
}
