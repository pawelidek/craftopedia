package com.javadevwannabes.craftopedia.service;

import com.javadevwannabes.craftopedia.domain.Category;
import com.javadevwannabes.craftopedia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public void addCategory(Category category) {
    categoryRepository.save(category);
  }
}