package com.javadevwannabes.craftopedia.domain.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StyleResponse {

  @JsonProperty("name")
  private String name;

  @JsonProperty("shortName")
  private String styleShortName;

  @JsonProperty("description")
  private String styleDescription;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStyleShortName() {
    return styleShortName;
  }

  public void setStyleShortName(String styleShortName) {
    this.styleShortName = styleShortName;
  }

  public String getStyleDescription() {
    return styleDescription;
  }

  public void setStyleDescription(String styleDescription) {
    this.styleDescription = styleDescription;
  }

  @Override
  public String toString() {
    return "StyleResponse{" +
        "name='" + name + '\'' +
        ", styleShortName='" + styleShortName + '\'' +
        ", styleDescription='" + styleDescription + '\'' +
        '}';
  }
}
