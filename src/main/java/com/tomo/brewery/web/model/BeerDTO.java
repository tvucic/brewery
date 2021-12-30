package com.tomo.brewery.web.model;

import lombok.*;

import java.util.UUID;

@Data
public class BeerDTO
{
    private UUID id;
    private String beerStyle;
    private String beerName;
    private Long upc;

    public BeerDTO(UUID id, String beerStyle, String beerName, Long upc)
    {
        this.id = id;
        this.beerStyle = beerStyle;
        this.beerName = beerName;
        this.upc = upc;
    }

    public BeerDTO()
    {
    }


    public static BeerDTOBuilder builder()
    {
        return new BeerDTOBuilder();
    }

    protected boolean canEqual(final Object other)
    {
        return other instanceof BeerDTO;
    }

    public static class BeerDTOBuilder
    {
        private UUID id;
        private String beerStyle;
        private String beerName;
        private Long upc;

        BeerDTOBuilder() {
        }

        public BeerDTOBuilder id(UUID id)
        {
            this.id = id;
            return this;
        }

        public BeerDTOBuilder beerStyle(String beerStyle)
        {
            this.beerStyle = beerStyle;
            return this;
        }

        public BeerDTOBuilder beerName(String beerName)
        {
            this.beerName = beerName;
            return this;
        }

        public BeerDTOBuilder upc(Long upc)
        {
            this.upc = upc;
            return this;
        }

        public BeerDTO build()
        {
            return new BeerDTO(id, beerStyle, beerName, upc);
        }

        public String toString()
        {
            return "BeerDTO.BeetDTOBuilder(id=" + this.id + ", beerStyle=" + this.beerStyle + ", beerName=" + this.beerName + ", upc=" + this.upc + ")";
        }
    }

}
