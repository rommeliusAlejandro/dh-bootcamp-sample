package com.dharbor.stock.model.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleCreatedEvent {

    public SaleCreatedEvent() {

    }

    private String saleId;
    private String productId;
    private Integer quantity;
    private String userId;

}
