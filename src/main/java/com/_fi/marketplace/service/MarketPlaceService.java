package com._fi.marketplace.service;

import com._fi.marketplace.dto.*;
import com._fi.marketplace.entity.EmiPlan;
import com._fi.marketplace.entity.Product;
import com._fi.marketplace.entity.ProductHighlight;
import com._fi.marketplace.entity.ProductVariant;
import com._fi.marketplace.repository.EmiPlanRepository;
import com._fi.marketplace.repository.ProductHighlightRepository;
import com._fi.marketplace.repository.ProductRepository;
import com._fi.marketplace.repository.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketPlaceService {

    private final ProductRepository productRepository;
    private final ProductVariantRepository productVariantRepository;
    private final EmiPlanRepository emiPlanRepository;
    private final ProductHighlightRepository productHighlightRepository;
    public AllProductResponseDto getAllProducts(int page, int size) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("id").ascending()
        );

        Page<Product> productPage =
                productRepository.findAll(pageable);

        List<ProductResponseDto> products =
                productPage.getContent()
                        .stream()
                        .map(product->
                                 new ProductResponseDto(
                                        product.getId(),
                                         product.getName(),
                                         product.getBrand(),
                                         product.getCategory(),
                                         product.getBasePrice(),
                                         product.getBaseMrp(),
                                         product.getImageUrl()
        ))
                        .toList();

        return new AllProductResponseDto(
                products,
                productPage.getNumber(),
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()
        );
    }

    public ProductDetailResponseDto getProductDetailById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                        new RuntimeException("Product not found")
                );
        List<ProductVariant> variants = productVariantRepository.findByProductId(productId);
        if (variants.isEmpty()) {
            throw new RuntimeException(
                    "Variants are not available for this product"
            );
        }
        List<EmiPlan> emiPlans = emiPlanRepository.findByProductId(productId);
        if (emiPlans.isEmpty()) {
            throw new RuntimeException(
                    "EMI plans are not available for this product"
            );
        }
        List<ProductHighlight> highlights =  productHighlightRepository.findByProductId(productId);
        if (highlights.isEmpty()) {
            throw new RuntimeException(
                    "Product highlights are not available for this product"
            );
        }

        List<ProductVariantResponseDto> variantResponses =
                variants.stream()
                        .map(variant ->
                                new ProductVariantResponseDto(
                                        variant.getId(),
                                        variant.getVariantName(),
                                        variant.getPrice(),
                                        variant.getMrp(),
                                        variant.getStock(),
                                        variant.isInStock()
                                )
                        )
                        .toList();

        List<EmiResposeDto> emiResponses =
                emiPlans.stream()
                        .map(emiPlan ->
                                new EmiResposeDto(
                                        emiPlan.getId(),
                                        emiPlan.getTenureMonths(),
                                        emiPlan.getMonthlyAmount(),
                                        emiPlan.getInterestRate(),
                                        emiPlan.getProcessingFee()
                                )
                        )
                        .toList();

        List<ProductHighlightDto> highlightResponses =
                highlights.stream()
                        .map(highlight ->
                                new ProductHighlightDto(
                                        highlight.getId(),
                                        highlight.getHighlight()
                                )
                        )
                        .toList();



        return new ProductDetailResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getCategory(),
                product.getBasePrice(),
                product.getBaseMrp(),
                product.getImageUrl(),
                emiResponses,
                variantResponses,
                highlightResponses
        );
    }

    public AllProductResponseDto getAllProductsByCategory(String category,int page,int size) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("id").ascending()
        );

        Page<Product> productPage = productRepository.findByCategory(category, pageable);

        if(productPage == null){
            throw new RuntimeException("Products are not available for this product");
        }

        List<ProductResponseDto> products = productPage.getContent()
                        .stream()
                        .map(product -> new ProductResponseDto(
                                product.getId(),
                                product.getName(),
                                product.getBrand(),
                                product.getCategory(),
                                product.getBasePrice(),
                                product.getBaseMrp(),
                                product.getImageUrl()
                        ))
                        .toList();

        return new AllProductResponseDto(
                products,
                productPage.getNumber(),
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()

        );
    }



}
