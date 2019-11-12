package com.javadevwannabes.craftopedia.service.apimanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javadevwannabes.craftopedia.domain.jsonapi.BeerResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParserService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private ObjectMapper objectMapper;

  @Autowired
  public ParserService(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public List<BeerResponse> parseBeersFromFile(File beersFile) throws IOException {

    logger.info("Parsing data from file");
    JsonNode jsonNode = objectMapper.readTree(beersFile);

    return objectMapper.readValue(jsonNode.get("data").toString(),
        new TypeReference<List<BeerResponse>>() {
        });
  }

  public List<BeerResponse> parseBeersFromAPI(String beersFile) throws IOException {

    logger.info("Parsing data from API");
    JsonNode jsonNode = objectMapper.readTree(beersFile);

    return objectMapper.readValue(jsonNode.get("data").toString(),
        new TypeReference<List<BeerResponse>>() {
        });
  }
}