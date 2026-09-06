//package com._fi.marketplace.service;
//
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
//@Service
//public class EmiCalculatorService {
//
//    public BigDecimal calculateMonthlyEmi(
//            BigDecimal principal,
//            BigDecimal annualInterestRate,
//            int tenureMonths
//    ) {
//
//        if (principal == null || principal.compareTo(BigDecimal.ZERO) <= 0) {
//            throw new IllegalArgumentException("Principal must be greater than zero");
//        }
//
//        if (tenureMonths <= 0) {
//            throw new IllegalArgumentException("Tenure must be greater than zero");
//        }
//
//        // No-cost EMI
//        if (annualInterestRate == null ||
//                annualInterestRate.compareTo(BigDecimal.ZERO) == 0) {
//
//            return principal
//                    .divide(
//                            BigDecimal.valueOf(tenureMonths),
//                            2,
//                            RoundingMode.HALF_UP
//                    );
//        }
//
//        // Monthly interest rate
//        double monthlyRate =
//                annualInterestRate.doubleValue() / 12 / 100;
//
//        double p = principal.doubleValue();
//        int n = tenureMonths;
//
//        double emi =
//                p *
//                        monthlyRate *
//                        Math.pow(1 + monthlyRate, n) /
//                        (Math.pow(1 + monthlyRate, n) - 1);
//
//        return BigDecimal
//                .valueOf(emi)
//                .setScale(2, RoundingMode.HALF_UP);
//    }
//}
