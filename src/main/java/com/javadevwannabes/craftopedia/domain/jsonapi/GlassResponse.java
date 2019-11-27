package com.javadevwannabes.craftopedia.domain.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javadevwannabes.craftopedia.domain.Beer;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GlassResponse {

  @JsonProperty("name")
  private String name;

  @JsonProperty("beers")
  private List<Beer> beers;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Beer> getBeers() {
    return beers;
  }

  public void setBeers(List<Beer> beers) {
    this.beers = beers;
  }

  @Override
  public String toString() {
    return "GlassResponse{" +
        "glassName='" + name + '\'' +
        ", beers=" + beers +
        '}';
  }
}
