package com.tomo.brewery.web.controller;

import com.tomo.brewery.services.BeerService;
import com.tomo.brewery.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDTO beetDTO)
    {
        BeerDTO savedBeerDTO = beerService.saveNewBeer(beetDTO);

        HttpHeaders headers = new HttpHeaders();
        //todo add host name to url
        headers.add("Location", "/api/v1/beer" + savedBeerDTO.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"}) // Idempotent method
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beetDTO)
    {
        beerService.updateBeer(beerId, beetDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
