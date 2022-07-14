package com.example.supplychainmanagement.dto.response;

import lombok.Data;
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
