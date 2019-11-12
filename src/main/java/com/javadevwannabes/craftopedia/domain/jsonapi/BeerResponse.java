package com.javadevwannabes.craftopedia.domain.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"id", "nameDisplay", "abv", "glasswareId", "styleId", "isOrganic", "isRetired", "labels", "status", "statusDisplay", "createDate", "updateDate", "glass", "style", })
public class BeerResponse {

  @JsonProperty("name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BeerResponse{");
    sb.append("name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
