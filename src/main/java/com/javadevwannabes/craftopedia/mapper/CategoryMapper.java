package com.javadevwannabes.craftopedia.mapper;

import com.javadevwannabes.craftopedia.domain.Category;
import com.javadevwannabes.craftopedia.domain.jsonapi.CategoryResponse;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public List<Category> mapApiToEntity(List<CategoryResponse> categoryList) {

    List<Category> categories = new ArrayList<>();

    categoryList.forEach(categoryApi -> {
      Category category = new Category();
      category.setName(categoryApi.getName());
      categories.add(category);
    });

    logger.info("Category response has been mapped to entity");

    return categories;
  }
}