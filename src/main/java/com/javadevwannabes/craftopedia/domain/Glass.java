package com.javadevwannabes.craftopedia.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "glassware")
public class Glass {

  @Id
  @Column(name = "glass_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  private String glassName;

  @OneToMany(mappedBy = "glassware", cascade = CascadeType.ALL)
  private List<Beer> beers = new ArrayList<>();

  public Glass(@NotNull String glassName,
      List<Beer> beers) {
    this.glassName = glassName;
    this.beers = beers;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGlassName() {
    return glassName;
  }

  public void setGlassName(String glassName) {
    this.glassName = glassName;
  }

  public List<Beer> getBeers() {
    return beers;
  }

  public void setBeers(List<Beer> beers) {
    this.beers = beers;
  }
}
