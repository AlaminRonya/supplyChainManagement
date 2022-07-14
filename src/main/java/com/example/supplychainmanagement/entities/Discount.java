package com.example.supplychainmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

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
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    private Double discountPercent = 0.00;
    private Boolean active = false;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;

//    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "product_discount", joinColumns = @JoinColumn(name = "discount_id", referencedColumnName = "id", nullable = true),
//            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = true))
//    @JsonIgnoreProperties("discounts")
//    private Product product;

}
