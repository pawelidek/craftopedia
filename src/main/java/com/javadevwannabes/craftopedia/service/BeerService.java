package com.javadevwannabes.craftopedia.service;

import com.javadevwannabes.craftopedia.domain.Beer;
import com.javadevwannabes.craftopedia.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

  private BeerRepository beerRepository;

  @Autowired
  public BeerService(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  public void addBeer(Beer beer) {
    beerRepository.save(beer);
  }
}