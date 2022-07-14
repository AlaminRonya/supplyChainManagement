package com.example.supplychainmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString
public class ProductCategoryDto {
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 25, message = "size must be between 1 and 25")
    private String name;

    @NotBlank(message = "*must not be blank")
    @Size(min = 4, max = 25, message = "size must be between 4 and 25")
    private String desc;



}
