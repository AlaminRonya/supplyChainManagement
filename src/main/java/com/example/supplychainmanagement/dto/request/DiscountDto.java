package com.example.supplychainmanagement.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DiscountDto {

    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String name;

    @NotBlank(message = "*must not be blank")
    @Size(min = 4, max = 255, message = "size must be between 4 and 255")
    private String description;

//    private Double discountPercent;

}
