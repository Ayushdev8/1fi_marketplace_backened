package com._fi.marketplace.controller;


import com._fi.marketplace.dto.AllProductResponseDto;
import com._fi.marketplace.dto.ProductDetailResponseDto;
import com._fi.marketplace.entity.Product;
import com._fi.marketplace.service.MarketPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class MarketPlaceController {
    private final MarketPlaceService marketPlaceService;
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        AllProductResponseDto products = marketPlaceService.getAllProducts(page, size);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {
        System.out.println("get product details ");
        ProductDetailResponseDto response = marketPlaceService.getProductDetailById(productId);
        return ResponseEntity.ok(response);

    }
    @GetMapping("/category/{category}")
    public ResponseEntity<?> getCategory(@PathVariable String category,
                                            @RequestParam(defaultValue ="0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        AllProductResponseDto products = marketPlaceService.getAllProductsByCategory(category,page, size);

        return ResponseEntity.ok(products);

    }

}
