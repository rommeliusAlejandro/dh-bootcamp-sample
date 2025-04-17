package com.dharbor.sales.model.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SaleCreatedEvent {


    public SaleCreatedEvent(String saleId, String productId, Integer quantity, UUID userId) {
        this.saleId = saleId;
        this.productId = productId;
        this.quantity = quantity;
        this.userId = userId;
    }

    private String saleId;
    private String productId;
    private Integer quantity;
    private UUID userId;

}
