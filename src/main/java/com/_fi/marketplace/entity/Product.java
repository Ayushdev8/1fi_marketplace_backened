package com._fi.marketplace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String brand;
    private String category;
    private BigDecimal basePrice;
    private BigDecimal baseMrp;
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    List<ProductVariant> productVariants;


    @OneToMany(mappedBy = "product")
    List<EmiPlan> emiPlans;

    @OneToMany(mappedBy = "product")
    List<ProductHighlight>  productHighlights;
}
