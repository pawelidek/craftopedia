package com.javadevwannabes.craftopedia.service.apimanager;

import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiConsumer {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private static final String APIKEY = "1d1eec55b757670e7f01188b18aaecc1";
  private static final String URI = "https://sandbox-api.brewerydb.com/v2/beers/?";

  private WebTarget webTarget;
  private ParserService parserService;

  @Autowired
  public ApiConsumer(ParserService parserService) {
    this.parserService = parserService;
  }

  public String consume() throws IOException {

    Integer lastPage = checkLastPage();
    Client client = ClientBuilder.newClient();
    StringBuilder apiResponse = new StringBuilder();

    for (int i = 1; i <=
//        lastPage
        2
        ; i++) {
      webTarget = client.target(URI).queryParam("key", APIKEY).queryParam("p", i);
      logger.info("* API response for page '{}' prepared", i);
      Response response = webTarget.request().get();
      String resp = response.readEntity(String.class);
      response.close();
      apiResponse.append(resp);
    }
    return apiResponse.toString();
  }

  private Integer checkLastPage() throws IOException {
    Client client = ClientBuilder.newClient();
    webTarget = client.target(URI).queryParam("key", APIKEY);
    Response response = webTarget.request().get();
    String resp = response.readEntity(String.class);
    response.close();
    Integer lastPage = parserService.findLastPage(resp);
    logger.info("Overall number of API pages = '{}'", lastPage);
    return lastPage;
  }
}