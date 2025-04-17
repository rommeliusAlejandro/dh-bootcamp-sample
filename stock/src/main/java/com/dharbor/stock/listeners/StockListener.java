package com.dharbor.stock.listeners;

import com.dharbor.stock.model.events.SaleCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockListener {


    @KafkaListener(topics = "sales.created", groupId = "stock-group")
    public void handleSaleCreated(SaleCreatedEvent saleCreatedEvent) {
        log.debug("----- Listening ----");
        log.debug(saleCreatedEvent.getSaleId());
    }

}
