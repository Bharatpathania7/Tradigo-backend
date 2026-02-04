package com.tradigo.tradigo_backend.controller;

import com.tradigo.tradigo_backend.model.Product;
import com.tradigo.tradigo_backend.repository.ProductRepository;
import com.tradigo.tradigo_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/top")
    public Object topProducts() {
        return productService.getTopProducts();
    }

    @GetMapping
    public List<Product> getProducts(
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable).getContent();
    }
}
