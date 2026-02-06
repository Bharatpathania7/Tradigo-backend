package com.tradigo.tradigo_backend.service;

import com.tradigo.tradigo_backend.model.Product;
import com.tradigo.tradigo_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product addProduct(Product product) {
        product.setCreatedAt(System.currentTimeMillis());
        product.setActive(true);
        return repository.save(product);
    }

    public List<Product> getMyProducts(String wholesalerId) {
        return repository.findByWholesalerId(wholesalerId);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }

    public List<Product> getTopProducts() {
        return repository.findTop10ByIsActiveTrue();
    }
}
