package com.sk.msscbrewery.controller;

import com.sk.msscbrewery.services.BeerService;
import com.sk.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeer(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBeer(@RequestBody  BeerDto beerDto) {

        BeerDto savedDto = beerService.saveBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/" + savedDto.getId().toString() );

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody  BeerDto beerDto) {

        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBeer(@PathVariable UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}
