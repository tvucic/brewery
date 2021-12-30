package com.tomo.brewery.services.v2;

import com.tomo.brewery.web.model.BeerDTO;
import com.tomo.brewery.web.model.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2
{
    BeerDTOV2 getBeerById(UUID beerId);

    BeerDTOV2 saveNewBeer(BeerDTOV2 beetDTO);

    void updateBeer(UUID beerId, BeerDTOV2 beetDTO);

    void deleteById(UUID beerId);
}
