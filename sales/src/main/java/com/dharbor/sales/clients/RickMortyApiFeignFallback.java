package com.dharbor.sales.clients;

import com.dharbor.sales.model.rest.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RickMortyApiFeignFallback implements RickMortyApiFeignClient {

    @Override
    public Character findById (Integer id){
        log.warn("Fallback for RickMorty");
        return new Character();
    }
}
