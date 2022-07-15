package com.example.supplychainmanagement.dto.response;

import com.example.supplychainmanagement.entities.Attachment;
import com.example.supplychainmanagement.entities.Discount;
import com.example.supplychainmanagement.entities.ProductCategory;
import com.example.supplychainmanagement.entities.ProductInventory;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class ResponseProductDto {

    private Long id;
    private String name;
    private String description;
    private String SKU;
    private Double price;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private ProductCategory category;
    private ProductInventory productInventory;
    private Discount discount;
    private List<Attachment> photosAttachmentList;

}
