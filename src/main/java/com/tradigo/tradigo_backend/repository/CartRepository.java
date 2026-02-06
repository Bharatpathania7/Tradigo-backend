package com.tradigo.tradigo_backend.repository;

import com.tradigo.tradigo_backend.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<CartItem, String> {
    List<CartItem> findByUserId(String userId);
}
