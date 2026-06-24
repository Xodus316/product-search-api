package com.portfolio.productsearchapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.productsearchapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import com.portfolio.productsearchapi.model.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5174") // Allow requests from the React frontend
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String query) {
        return productService.searchProducts(query);
    }
}
