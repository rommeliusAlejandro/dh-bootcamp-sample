package com.dharbor.notifcations.model.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleCreatedEvent {

    private String saleId;
    private String productId;
    private Integer quantity;
    private String userId;

}
