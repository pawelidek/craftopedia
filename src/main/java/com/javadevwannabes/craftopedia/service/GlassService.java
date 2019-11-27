package com.javadevwannabes.craftopedia.service;

import com.javadevwannabes.craftopedia.domain.Glass;
import com.javadevwannabes.craftopedia.repository.GlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlassService {

  private GlassRepository glassRepository;

  @Autowired
  public GlassService(GlassRepository glassRepository) {
    this.glassRepository = glassRepository;
  }

  public void addGlass(Glass glass) {
    glassRepository.save(glass);
  }
}