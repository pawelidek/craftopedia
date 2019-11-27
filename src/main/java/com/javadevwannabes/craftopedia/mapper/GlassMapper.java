package com.javadevwannabes.craftopedia.mapper;

import com.javadevwannabes.craftopedia.domain.Glass;
import com.javadevwannabes.craftopedia.domain.jsonapi.GlassResponse;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GlassMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public List<Glass> mapApiToEntity(List<GlassResponse> glassList) {

    List<Glass> glasses = new ArrayList<>();

    glassList.forEach(glassApi -> {
      Glass glass = new Glass();
      glass.setName(glassApi.getName());
      glasses.add(glass);
    });

    logger.info("Glass response has been mapped to entity");

    return glasses;
  }
}