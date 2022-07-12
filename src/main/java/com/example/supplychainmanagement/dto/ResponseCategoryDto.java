package com.example.supplychainmanagement.dto;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
public class ResponseCategoryDto {
    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private LocalDate deletedAt;
    private Boolean active = true;
}
