package com.javadevwannabes.craftopedia.service.apimanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javadevwannabes.craftopedia.domain.jsonapi.BeerResponse;
import com.javadevwannabes.craftopedia.domain.jsonapi.CategoryResponse;
import com.javadevwannabes.craftopedia.domain.jsonapi.GlassResponse;
import com.javadevwannabes.craftopedia.domain.jsonapi.StyleResponse;
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

  public List<BeerResponse> parseBeersFromAPI(String beers) throws IOException {

    logger.info("Parsing beers from API");
    JsonNode jsonNode = objectMapper.readTree(beers);
    return objectMapper.readValue(jsonNode.get("data").toString(),
        new TypeReference<List<BeerResponse>>() {
        });
  }

  public List<GlassResponse> parseGlassesFromAPI(String glasses) throws IOException {

    logger.info("Parsing glasses from API");
    JsonNode jsonNode = objectMapper.readTree(glasses);
    return objectMapper.readValue(jsonNode.get("data").toString(),
        new TypeReference<List<GlassResponse>>() {
        });
  }

  public List<StyleResponse> parseStylesFromAPI(String styles) throws IOException {

    logger.info("Parsing styles from API");
    JsonNode jsonNode = objectMapper.readTree(styles);
    return objectMapper.readValue(jsonNode.get("data").toString(),
        new TypeReference<List<StyleResponse>>() {
        });
  }

  public List<CategoryResponse> parseCategoriesFromAPI(String categories) throws IOException {

    logger.info("Parsing categories from API");
    JsonNode jsonNode = objectMapper.readTree(categories);
    return objectMapper.readValue(jsonNode.get("data").toString(),
        new TypeReference<List<CategoryResponse>>() {
        });
  }

  public Integer findLastPage(String beers) throws IOException {

    logger.info("* Checking number of API pages");
    JsonNode jsonNode = objectMapper.readTree(beers);

    return objectMapper.readValue(jsonNode.get("numberOfPages").toString(),
        new TypeReference<Integer>() {
        });
  }

//  public List<BeerResponse> parseBeersFromFile(File beersFile) throws IOException {
//
//    logger.info("Parsing data from file");
//    JsonNode jsonNode = objectMapper.readTree(beersFile);
//
//    return objectMapper.readValue(jsonNode.get("data").toString(),
//        new TypeReference<List<BeerResponse>>() {
//        });
//  }
}