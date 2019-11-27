package com.javadevwannabes.craftopedia.service.apimanager;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiInitializer {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private ApiLoader apiLoader;

  @Autowired
  public ApiInitializer(ApiConsumer apiConsumer,
      ApiLoader apiLoader) {
    this.apiLoader = apiLoader;
  }

  @PostConstruct
  protected void init() {
    apiLoader.loadBeerDataToDatabase();
    apiLoader.loadGlassDataToDatabase();
    apiLoader.loadStyleDataToDatabase();
    apiLoader.loadCategoryDataToDatabase();
  }
}