package com.portfolio.productsearchapi.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String productId;
    private String name;
    private String manufacturer;
    private String category;
    private Double price;
    private String description;
    private Map<String, String> attributes;
}
