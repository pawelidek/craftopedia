package com.javadevwannabes.craftopedia.service.apimanager;

import com.javadevwannabes.craftopedia.domain.Beer;
import com.javadevwannabes.craftopedia.domain.jsonapi.BeerResponse;
import com.javadevwannabes.craftopedia.mapper.BeerMapper;
import com.javadevwannabes.craftopedia.repository.BeerRepository;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerApiConsumer {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private static final String APIKEY = "1d1eec55b757670e7f01188b18aaecc1";
  private static final String URI = "https://sandbox-api.brewerydb.com/v2/beers/?";
  private WebTarget webTarget;
  private ParserService parserService;
  private BeerMapper beerMapper;
  private BeerRepository beerRepository;

  @Autowired
  public BeerApiConsumer(
      ParserService parserService, BeerMapper beerMapper,
      BeerRepository beerRepository) {
    this.parserService = parserService;
    this.beerMapper = beerMapper;
    this.beerRepository = beerRepository;
  }

  public void consume() throws IOException {

    Integer lastPage = checkLastPage();
    Client client = ClientBuilder.newClient();

    for (int i = 1; i <= lastPage; i++) {
      webTarget = client.target(URI).queryParam("key", APIKEY).queryParam("p", i);
      logger.info("* API response for page '{}' prepared", i);
      Response response = webTarget.request().get();
      String resp = response.readEntity(String.class);

      List<BeerResponse> beerList = parserService.parseBeersFromAPI(resp);
      loadDataToDatabase(beerList);
    }
  }

  private Integer checkLastPage() throws IOException {
    Client client = ClientBuilder.newClient();
    webTarget = client.target(URI).queryParam("key", APIKEY);
    Response response = webTarget.request().get();
    String resp = response.readEntity(String.class);
    Integer lastPage = parserService.findLastPage(resp);
    logger.info("Overall number of API pages = '{}'", lastPage);
    return lastPage;
  }

  private void loadDataToDatabase(List<BeerResponse> beerList) {
    logger.info("Loading beers to DB");
    List<Beer> beers = beerMapper.mapApiToEntity(beerList);
    beers.forEach(beer -> beerRepository.save(beer));
  }
}