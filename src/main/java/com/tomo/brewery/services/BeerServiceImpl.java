package com.tomo.brewery.services;

import com.tomo.brewery.web.model.BeerDTO;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService
{
    static Logger LOG = Logger.getLogger(BeerServiceImpl.class);
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

    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(UUID beerId)
    {
        LOG.debug("Delting beer...");
    }
}
