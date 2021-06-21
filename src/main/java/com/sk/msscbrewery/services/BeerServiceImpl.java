package com.sk.msscbrewery.services;

import com.sk.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeer(UUID beerId) {
        return BeerDto.builder().id(beerId)
                .beerName("Bluemoon")
                .beerStyle("Beligian Ale")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //// TODO: 6/21/2021  
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("Deleting the Beer ***************");
    }
}
