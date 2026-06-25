package com.portfolio.productsearchapi.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portfolio.productsearchapi.model.Product;
import com.portfolio.productsearchapi.repository.ProductRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> searchProducts(String query) {
        if (query == null || query.isEmpty()) {
            return productRepository.findAll();
        }
        
        return productRepository.findByNameContainingIgnoreCaseOrManufacturerContainingIgnoreCase(query, query);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Seeds the MongoDB database with mock products if it's empty. This method is called after the bean's properties have been set.
     */
    @PostConstruct
    public void seedDatabase() {
        if (productRepository.count() == 0) {
            System.out.println("Database is empty. Seeding mock products into MongoDB...");
            
            List<Product> initialProducts = Arrays.asList(
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

            productRepository.saveAll(initialProducts);
            System.out.println("Database seeding complete!");
        }
    }
}
