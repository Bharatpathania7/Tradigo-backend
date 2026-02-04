package com.tradigo.tradigo_backend.service;

import com.tradigo.tradigo_backend.model.Product;
import com.tradigo.tradigo_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getTopProducts() {
        return productRepository.findTop10ByIsActiveTrue();
    }
}
