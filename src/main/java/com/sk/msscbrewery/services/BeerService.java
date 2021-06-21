package com.sk.msscbrewery.services;

import com.sk.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeer(UUID beerId);
    BeerDto saveBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);

}
