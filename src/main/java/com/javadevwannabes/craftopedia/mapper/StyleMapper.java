package com.javadevwannabes.craftopedia.mapper;

import com.javadevwannabes.craftopedia.domain.Style;
import com.javadevwannabes.craftopedia.domain.jsonapi.StyleResponse;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StyleMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public List<Style> mapApiToEntity(List<StyleResponse> styleList) {

    List<Style> styles = new ArrayList<>();

    styleList.forEach(styleApi -> {
      Style style = new Style();
      style.setName(styleApi.getName());
      styles.add(style);
    });

    logger.info("Style response has been mapped to entity");

    return styles;
  }
}