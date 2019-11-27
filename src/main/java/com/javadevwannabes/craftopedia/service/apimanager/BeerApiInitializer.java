package com.javadevwannabes.craftopedia.service.apimanager;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeerApiInitializer {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private final BeerApiConsumer beerApiConsumer;

  @Autowired
  public BeerApiInitializer(BeerApiConsumer beerApiConsumer) {
    this.beerApiConsumer = beerApiConsumer;
  }

  @PostConstruct
  protected void init() {
    try {
      beerApiConsumer.consume();
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }
}