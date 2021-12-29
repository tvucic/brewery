package com.tomo.brewery.services;

import com.tomo.brewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService
{
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beetDTO);

    void updateBeer(UUID beerId, BeerDTO beetDTO);
}
