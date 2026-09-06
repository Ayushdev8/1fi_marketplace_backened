package com._fi.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductVariantResponseDto {
    private Long id;
    private String variantName;
    private BigDecimal price;
    private BigDecimal mrp;
    private Integer stock;
    private boolean inStock;
}
