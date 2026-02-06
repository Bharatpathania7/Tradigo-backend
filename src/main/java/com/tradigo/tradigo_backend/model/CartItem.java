package com.tradigo.tradigo_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
@Data
public class CartItem {

    @Id
    private String id;

    private String userId;
    private String productId;
    private int quantity;
}
