package com.example.supplychainmanagement.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "product_inventory")
public class ProductInventory {
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
    @Setter(AccessLevel.NONE)
    private Long id;
    private Long quantity;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
}
