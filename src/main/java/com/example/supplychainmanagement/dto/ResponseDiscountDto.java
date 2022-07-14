package com.example.supplychainmanagement.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDiscountDto {
    private Long id;
    private String name;
    private String description;
    private Double discountPercent;
    private Boolean active;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
}
