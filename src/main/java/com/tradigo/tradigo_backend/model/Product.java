package com.tradigo.tradigo_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String wholesalerId;

    private String name;
    private String description;
    private String category;

    private double pricePerUnit;
    private int minimumOrderQty;
    private int availableStock;

    private String imageUrl;

    private boolean isActive;

    private long createdAt;
}
