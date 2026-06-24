package com.portfolio.productsearchapi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.productsearchapi.model.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5174") // Allow requests from the React frontend
public class ProductController {
    @GetMapping
    public List<Product> getAllProducts() {
        return Arrays.asList(
            Product.builder()
                .productId("p-101")
                .name("Wireless Noise-Canceling Headphones")
                .manufacturer("Sony")
                .category("Electronics")
                .price(299.99)
                .description("Industry leading noise cancellation.")
                .attributes(Map.of("color", "Black"))
                .build(),
            Product.builder()
                .productId("p-102")
                .name("Mechanical Gaming Keyboard")
                .manufacturer("Keychron")
                .category("Electronics")
                .price(109.50)
                .description("Hot-swappable tactile switches.")
                .attributes(Map.of("color", "Grey"))
                .build()
        );
    }
}
