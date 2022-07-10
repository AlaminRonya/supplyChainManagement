package com.example.supplychainmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "discount")
public class Discount {
    @SequenceGenerator(
            name = "discount_sequence",
            sequenceName = "discount_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "discount_sequence"
    )
    private Long id;
    private String name;
    private String desc;
    private Double discountPercent;
    private Boolean active;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;

//    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "product_discount", joinColumns = @JoinColumn(name = "discount_id", referencedColumnName = "id", nullable = true),
//            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = true))
//    @JsonIgnoreProperties("discounts")
//    private Product product;

}
