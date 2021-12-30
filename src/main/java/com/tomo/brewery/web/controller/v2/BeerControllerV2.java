package com.tomo.brewery.web.controller.v2;

import com.tomo.brewery.services.BeerService;
import com.tomo.brewery.services.v2.BeerServiceV2;
import com.tomo.brewery.web.model.BeerDTO;
import com.tomo.brewery.web.model.v2.BeerDTOV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2
{
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerServiceV2)
    {
        this.beerService = beerServiceV2;
    }

    @GetMapping({"/{beerId}"}) // Spring will automatically match beerId parameter name, but with PathVariable it will do it explicitly.
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable("beerId") UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDTOV2 beetDTO)
    {
        BeerDTOV2 savedBeerDTO = beerService.saveNewBeer(beetDTO);

        HttpHeaders headers = new HttpHeaders();
        //todo add host name to url
        headers.add("Location", "/api/v1/beer" + savedBeerDTO.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"}) // Idempotent method
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTOV2 beetDTO)
    {
        beerService.updateBeer(beerId, beetDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    public void deleteBeer(@PathVariable("beerId") UUID beerId)
    {
        beerService.deleteById(beerId);
    }
}
