package com._fi.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmiPlan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer tenureMonths;
    private BigDecimal interestRate;
    private  BigDecimal monthlyAmount ;
    private BigDecimal processingFee;
    @Column(name = "total_amount_payable")
    private BigDecimal totalAmountPayable;
}
