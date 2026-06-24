package com.portfolio.productsearchapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.portfolio.productsearchapi.model.Product;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    
    List<Product> findByNameContainingIgnoreCaseOrManufacturerContainingIgnoreCase(String name, String manufacturer);
}
