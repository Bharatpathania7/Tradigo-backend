package com.tradigo.tradigo_backend.controller;

import com.tradigo.tradigo_backend.model.CartItem;
import com.tradigo.tradigo_backend.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    private final CartRepository cartRepository;

    // ✅ Add to cart
    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item,
                              Authentication authentication) {

        String email = authentication.getName(); // comes from JWT
        item.setUserId(email);

        return cartRepository.save(item);
    }

    @GetMapping
    public List<CartItem> getCart(Authentication authentication) {

        String email = authentication.getName();
        return cartRepository.findByUserId(email);
    }

}
