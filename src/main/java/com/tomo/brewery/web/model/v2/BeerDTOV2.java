package com.tomo.brewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTOV2
{
    private UUID id;
    private BeerStyleEnum beerStyle;
    private String beerName;
    private Long upc;
}
