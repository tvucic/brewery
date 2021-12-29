package com.tomo.brewery.services;

import com.tomo.brewery.web.model.BeetDTO;

import java.util.UUID;

public interface BeerService
{
    BeetDTO getBeerById(UUID beerId);
}
