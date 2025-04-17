package com.dharbor.sales.services;

import com.dharbor.sales.model.dto.NewSaleDto;
import com.dharbor.sales.model.events.SaleCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalesService {

    private final KafkaTemplate<String, SaleCreatedEvent> kafkaTemplate;


    public String createSale(NewSaleDto newSaleDto) {
      String saleId = UUID.randomUUID().toString();

      log.debug("Sale create: "+saleId);

      SaleCreatedEvent saleCreatedEvent = new SaleCreatedEvent(
              saleId,
              newSaleDto.getProductId(),
              newSaleDto.getQuantity(),
              newSaleDto.getUserId()
      );

      this.kafkaTemplate.send("sales.created", saleCreatedEvent);

      return saleId;
    }



}
