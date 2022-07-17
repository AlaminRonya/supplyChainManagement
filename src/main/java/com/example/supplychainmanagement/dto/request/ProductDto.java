package com.example.supplychainmanagement.dto.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
public class ProductDto {


    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 25, message = "*size must be between 1 and 25")
    private String name;

    @NotBlank(message = "*must not be blank")
    @Size(min = 4, max = 255, message = "size must be between 4 and 255")
    private String description;

    @NotBlank(message = "*must not be blank")
    @Size(min = 3, max = 255, message = "size must be between 4 and 255")
    private String SKU;

    @NotNull(message = "*must not be blank")
    @Min(value = 0, message = "*The value must be positive")
    private Double price;

    @NotNull(message = "*must not be blank")
    @Min(value = 1, message = "*The value must be positive")
    private Long quantity;

    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 25, message = "*size must be between 1 and 25")
    private String categoryName;

    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String discountName;


}
