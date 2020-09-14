package com.sfg.msscbeerservice.services;

import com.sfg.msscbeerservice.domain.Beer;
import com.sfg.msscbeerservice.repositories.BeerRepository;
import com.sfg.msscbeerservice.web.controller.NotFoundException;
import com.sfg.msscbeerservice.web.mappers.BeerMapper;
import com.sfg.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {

        return beerMapper.beerToBeerDto(beerRepository
                .findById(beerId)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId,BeerDto beerDto) {

        Beer beer = beerRepository
                .findById(beerId)
                .orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
