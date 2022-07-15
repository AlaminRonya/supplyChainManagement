package com.example.supplychainmanagement.converterDtoToPojo;

import com.example.supplychainmanagement.dto.request.ProductDto;
import com.example.supplychainmanagement.dto.response.ResponseProductDto;
import com.example.supplychainmanagement.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    public Product getProduct(ProductDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setSKU(dto.getSKU());
        product.setPrice(dto.getPrice());
        return product;
    }

    public ResponseProductDto getResponseProductDto(Product product){

        ResponseProductDto dto = new ResponseProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setSKU(product.getSKU());
        dto.setPrice(product.getPrice());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setModifiedAt(product.getModifiedAt());
        dto.setDeletedAt(product.getDeletedAt());
        dto.setPhotosAttachmentList(product.getPhotosAttachmentList());
        dto.setProductInventory(product.getProductInventory());
        dto.setCategory(product.getCategory());
        dto.setDiscount(product.getDiscount());

        return dto;
    }

    public List<ResponseProductDto> getAllResponseProductDto(List<Product> products){
        return products.stream().map(this::getResponseProductDto).collect(Collectors.toList());
    }
}
