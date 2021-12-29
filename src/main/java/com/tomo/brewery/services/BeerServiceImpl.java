package com.tomo.brewery.services;

import com.tomo.brewery.web.model.BeetDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService
{
    @Override
    public BeetDTO getBeerById(UUID beerId)
    {
        return BeetDTO.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeetDTO saveNewBeer(BeetDTO beetDTO)
    {
        return BeetDTO.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeetDTO beetDTO)
    {
        // todo impl would need real implementation
    }
}
