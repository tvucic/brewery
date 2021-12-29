package com.tomo.brewery.services;

import com.tomo.brewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService
{
    @Override
    public BeerDTO getBeerById(UUID beerId)
    {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beetDTO)
    {
        return BeerDTO.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO)
    {
        // todo impl would need real implementation
    }
}
