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
}
