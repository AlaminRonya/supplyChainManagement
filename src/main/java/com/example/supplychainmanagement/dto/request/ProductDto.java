package com.example.supplychainmanagement.dto.request;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String description;
    private String SKU;
    private Double price;
    private Integer quantity;
    private String categoryName;
    private String discountName;
}
