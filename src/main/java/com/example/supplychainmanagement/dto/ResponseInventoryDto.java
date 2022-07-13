package com.example.supplychainmanagement.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ResponseInventoryDto {
    private Long id;
    private Long quantity;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
}
