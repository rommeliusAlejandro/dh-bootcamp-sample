package com.dharbor.sales.rest;

import com.dharbor.sales.exceptions.SaleNotCompletedException;
import com.dharbor.sales.model.dto.NewSaleDto;
import com.dharbor.sales.model.rest.NewSaleRequest;
import com.dharbor.sales.services.NewSalesService;
import com.dharbor.sales.services.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class SalesController {

    private final NewSalesService newSalesService;

    private final SalesService salesService;


    @PostMapping("/sales/newSale")
    public ResponseEntity<String> newSale(@RequestBody NewSaleRequest newSaleRequest) {

        try {
            NewSaleDto newSaleDto = new NewSaleDto();
            newSaleDto.setUserId(newSaleRequest.getUserId());
            newSaleDto.setProductId(newSaleRequest.getProductId());
            newSaleDto.setQuantity(newSaleRequest.getQuantity());

            return  ResponseEntity.ok(this.newSalesService.newSale(newSaleDto));
        } catch (SaleNotCompletedException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

    }

    @PostMapping("/sales/create")
    public ResponseEntity<String> create(@RequestBody NewSaleRequest newSaleRequest) {

        try {
            NewSaleDto newSaleDto = new NewSaleDto();
            newSaleDto.setUserId(newSaleRequest.getUserId());
            newSaleDto.setProductId(newSaleRequest.getProductId());
            newSaleDto.setQuantity(newSaleRequest.getQuantity());

            return  ResponseEntity.ok(this.salesService.createSale(newSaleDto));
        } catch (SaleNotCompletedException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

    }

}
