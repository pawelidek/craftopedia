package com.javadevwannabes.craftopedia.mapper;

import com.javadevwannabes.craftopedia.domain.Beer;
import com.javadevwannabes.craftopedia.domain.jsonapi.BeerResponse;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BeerMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public List<Beer> mapApiToEntity(List<BeerResponse> beerList) {

    List<Beer> beers = new ArrayList<>();

    beerList.forEach(beerApi -> {
      Beer beer = new Beer();
      beer.setName(beerApi.getName());
      beer.setDescription(beerApi.getDescription());
      beer.setAbv(beerApi.getAbv());
//      beer.setOrganic(beerApi.isOrganic());
//      beer.setRetired(beerApi.isRetired());
//      beer.setSmallIconURL(beerApi.getSmallIconURL());
//      beer.setMediumIconURL(beerApi.getMediumIconURL());
//      beer.setLargeIconURL(beerApi.getLargeIconURL());
//      beer.setCategory(beerApi.getCategory());
//      beer.setStyle(beerApi.getStyle());
//      beer.setGlass(beerApi.getGlass());
      beers.add(beer);
    });

    logger.info("Beer response has been mapped to entity");

    return beers;
  }
}