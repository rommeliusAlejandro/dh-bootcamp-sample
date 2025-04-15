package com.dharbor.sales.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationFeignFallback implements NotificationsFeignClient {
        @Override
        public String sendNotification (String id){
            log.warn("Fallback for notifyUser");
            return "Not Send";
        }
}
