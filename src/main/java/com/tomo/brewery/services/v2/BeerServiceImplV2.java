package com.tomo.brewery.services.v2;

import com.tomo.brewery.web.model.v2.BeerDTOV2;
import com.tomo.brewery.web.model.v2.BeerStyleEnum;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Service
public class BeerServiceImplV2 implements BeerServiceV2
{
    static Logger LOG = Logger.getLogger(BeerServiceImplV2.class);
    @Override
    public BeerDTOV2 getBeerById(UUID beerId)
    {
        return BeerDTOV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PISLSNER)
                .build();
    }

    @Override
    public BeerDTOV2 saveNewBeer(BeerDTOV2 beetDTO)
    {
        return BeerDTOV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO)
    {

    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(UUID beerId)
    {
        LOG.debug("Delting beer...");
    }
}
