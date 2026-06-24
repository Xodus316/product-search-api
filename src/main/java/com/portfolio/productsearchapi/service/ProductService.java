package com.portfolio.productsearchapi.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portfolio.productsearchapi.model.Product;

@Service
public class ProductService {
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
                .build(),
            Product.builder()
                .productId("p-103")
                .name("Ergonomic Office Chair")
                .manufacturer("Herman Miller")
                .category("Furniture")
                .price(950.00)
                .description("Adjustable lumbar support.")
                .attributes(Map.of("color", "Graphite", "material", "Mesh"))
                .build(),
            Product.builder()
                .productId("p-104")
                .name("Stainless Steel Water Bottle")
                .manufacturer("Yeti")
                .category("Outdoors")
                .price(35.00)
                .description("Double-wall vacuum insulated.")
                .attributes(Map.of("color", "Navy"))
                .build()
        );
    }
}
