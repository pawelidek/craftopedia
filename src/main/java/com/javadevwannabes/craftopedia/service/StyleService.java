package com.javadevwannabes.craftopedia.service;

import com.javadevwannabes.craftopedia.domain.Style;
import com.javadevwannabes.craftopedia.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

  private StyleRepository styleRepository;

  @Autowired
  public StyleService(StyleRepository styleRepository) {
    this.styleRepository = styleRepository;
  }

  public void addStyle(Style style) {
    styleRepository.save(style);
  }
}