package com._fi.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private Long productId;
    private String productName;
//    private String productDescription;
    private String brand;
    private String category;
    private BigDecimal basePrice;
    private BigDecimal baseMrp;
    private String imageUrl;
}
