package com.dharbor.sales.clients;

import com.dharbor.sales.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class UsersFeignFallback implements UsersFeignClient{

    @Override
    public User findById(UUID id) {
        log.error("Fallback for getUser (userId={}): {}", id);
        return new User();
    }

}
