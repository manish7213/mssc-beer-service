package com.sfg.msscbeerservice.web.controller;

import com.sfg.msscbeerservice.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author manish
 */

import java.util.UUID;
@Slf4j
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) {
        log.info("BeerController : getBeerById(-) : {0}", beerId);
        //todo: real impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        log.info("BeerController : saveNewBeer(-) : {0}", beerDto.getId());
        //todo: impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        log.info("BeerController : updateBeer(-,-) : {0}", beerId);
        //todo: impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
