package com.javadevwannabes.craftopedia.service.apimanager;

import com.javadevwannabes.craftopedia.domain.Beer;
import com.javadevwannabes.craftopedia.domain.Category;
import com.javadevwannabes.craftopedia.domain.Glass;
import com.javadevwannabes.craftopedia.domain.Style;
import com.javadevwannabes.craftopedia.domain.jsonapi.BeerResponse;
import com.javadevwannabes.craftopedia.domain.jsonapi.CategoryResponse;
import com.javadevwannabes.craftopedia.domain.jsonapi.GlassResponse;
import com.javadevwannabes.craftopedia.domain.jsonapi.StyleResponse;
import com.javadevwannabes.craftopedia.mapper.BeerMapper;
import com.javadevwannabes.craftopedia.mapper.CategoryMapper;
import com.javadevwannabes.craftopedia.mapper.GlassMapper;
import com.javadevwannabes.craftopedia.mapper.StyleMapper;
import com.javadevwannabes.craftopedia.service.BeerService;
import com.javadevwannabes.craftopedia.service.CategoryService;
import com.javadevwannabes.craftopedia.service.GlassService;
import com.javadevwannabes.craftopedia.service.StyleService;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiLoader {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private ParserService parserService;
  private ApiConsumer apiConsumer;
  private BeerMapper beerMapper;
  private GlassMapper glassMapper;
  private StyleMapper styleMapper;
  private CategoryMapper categoryMapper;
  private BeerService beerService;
  private GlassService glassService;
  private StyleService styleService;
  private CategoryService categoryService;

  @Autowired
  public ApiLoader(ParserService parserService,
      ApiConsumer apiConsumer, BeerMapper beerMapper,
      GlassMapper glassMapper, StyleMapper styleMapper,
      CategoryMapper categoryMapper, BeerService beerService,
      GlassService glassService, StyleService styleService,
      CategoryService categoryService) {
    this.parserService = parserService;
    this.apiConsumer = apiConsumer;
    this.beerMapper = beerMapper;
    this.glassMapper = glassMapper;
    this.styleMapper = styleMapper;
    this.categoryMapper = categoryMapper;
    this.beerService = beerService;
    this.glassService = glassService;
    this.styleService = styleService;
    this.categoryService = categoryService;
  }

  public void loadBeerDataToDatabase() {
    logger.info("Loading beers to DB");
    try {
      List<BeerResponse> beerList = parserService.parseBeersFromAPI(apiConsumer.consume());
      List<Beer> beers = beerMapper.mapApiToEntity(beerList);
      beers.forEach(beer -> beerService.addBeer(beer));
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void loadGlassDataToDatabase() {
    logger.info("Loading glasses to DB");
    try {
      List<GlassResponse> glassList = parserService.parseGlassesFromAPI(apiConsumer.consume());
      List<Glass> glasses = glassMapper.mapApiToEntity(glassList);
      glasses.forEach(glass -> glassService.addGlass(glass));
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void loadStyleDataToDatabase() {
    logger.info("Loading styles to DB");
    try {
      List<StyleResponse> styleList = parserService.parseStylesFromAPI(apiConsumer.consume());
      List<Style> styles = styleMapper.mapApiToEntity(styleList);
      styles.forEach(style -> styleService.addStyle(style));
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void loadCategoryDataToDatabase() {
    logger.info("Loading categories to DB");
    try {
      List<CategoryResponse> categoryList = parserService
          .parseCategoriesFromAPI(apiConsumer.consume());
      List<Category> categories = categoryMapper.mapApiToEntity(categoryList);
      categories.forEach(category -> categoryService.addCategory(category));
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }
}