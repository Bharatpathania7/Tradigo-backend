package com.tradigo.tradigo_backend.controller;

import com.tradigo.tradigo_backend.model.Product;
import com.tradigo.tradigo_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService service;

    // 🔥 Retailer marketplace
    @GetMapping
    public List<Product> getProducts(
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getTopProducts(); // you can change later to pageable
    }

    // 🔥 Top products (home/dashboard)
    @GetMapping("/top")
    public List<Product> topProducts() {
        return service.getTopProducts();
    }

    // 🔥 Wholesaler add product
    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // 🔥 Wholesaler my products
    @GetMapping("/wholesaler/{wholesalerId}")
    public List<Product> myProducts(@PathVariable String wholesalerId) {
        return service.getMyProducts(wholesalerId);
    }

    // 🔥 Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.deleteProduct(id);
        return "Deleted";
    }
}
