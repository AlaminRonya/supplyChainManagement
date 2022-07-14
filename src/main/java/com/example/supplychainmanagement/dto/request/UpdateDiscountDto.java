package com.example.supplychainmanagement.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UpdateDiscountDto {
    @NotNull
    @Min(value = 0, message = "The value must be positive")
    private Double discountPercent;
}
