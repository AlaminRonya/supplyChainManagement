package com.example.supplychainmanagement.dto.response;


import lombok.Data;
import lombok.ToString;



@Data
@ToString
public class ResponseUpdateProductDto {

    private Long id;
    private String name;
    private String description;
    private String SKU;
    private Double price;
    private Long quantity;
    private String categoryName;
    private String discountName;

}
