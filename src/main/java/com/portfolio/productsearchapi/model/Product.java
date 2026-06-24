package com.portfolio.productsearchapi.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productId;
    private String name;
    private String manufacturer;
    private String category;
    private Double price;
    private String description;
    private Map<String, String> attributes;
}
