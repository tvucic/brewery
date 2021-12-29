package com.tomo.brewery.web.controller;

import com.tomo.brewery.services.BeerService;
import com.tomo.brewery.web.model.BeetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController
{
    private final BeerService beerService;

    public BeerController(BeerService beerService)
    {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"}) // Spring will automatically match beerId parameter name, but with PathVariable it will do it explicitly.
    public ResponseEntity<BeetDTO> getBeer(@PathVariable("beerId") UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
}
