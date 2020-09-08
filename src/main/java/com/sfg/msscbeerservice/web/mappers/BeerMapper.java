package com.sfg.msscbeerservice.web.mappers;

import com.sfg.msscbeerservice.domain.Beer;
import com.sfg.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})  //This can be a list
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
