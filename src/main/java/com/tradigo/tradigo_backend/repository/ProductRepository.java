package com.tradigo.tradigo_backend.repository;

import com.tradigo.tradigo_backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findTop10ByIsActiveTrue();
}
