package com.dharbor.sales.clients;

import com.dharbor.sales.model.rest.ProductReservationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StockFeignFallback implements StockFeignClient{
    @Override
    public  String reserve (ProductReservationRequest request){
        log.error("Fallback for reserveStock");
        return "Reservation failed";
    }
}
