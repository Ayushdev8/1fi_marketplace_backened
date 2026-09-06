package com._fi.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiResposeDto {
    private Long EmiId;
    private Integer tenureMonths;
    private BigDecimal monthlyAmount;
    private BigDecimal interestRate;
    private BigDecimal processingFee;
}
