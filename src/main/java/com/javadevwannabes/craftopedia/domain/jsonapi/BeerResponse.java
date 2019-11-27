package com.javadevwannabes.craftopedia.domain.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//import com.javadevwannabes.craftopedia.domain.Category;
//import com.javadevwannabes.craftopedia.domain.Style;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BeerResponse {

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("abv")
  private double abv;

//  @JsonProperty("isOrganic")
//  private boolean isOrganic;
//
//  @JsonProperty("isRetired")
//  private boolean isRetired;
//
//  @JsonProperty("smallIconURL")
//  private String smallIconURL;
//
//  @JsonProperty("mediumIconURL")
//  private String mediumIconURL;
//
//  @JsonProperty("largeIconURL")
//  private String largeIconURL;
//
//  @JsonProperty("cat")
//  private Category category;
//
//  @JsonProperty("style")
//  private Style style;
//
//  @JsonProperty("glass")
//  private Glass glass;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getAbv() {
    return abv;
  }

  public void setAbv(double abv) {
    this.abv = abv;
  }

//  public boolean isOrganic() {
//    return isOrganic;
//  }
//
//  public void setOrganic(boolean organic) {
//    isOrganic = organic;
//  }
//
//  public boolean isRetired() {
//    return isRetired;
//  }
//
//  public void setRetired(boolean retired) {
//    isRetired = retired;
//  }
//
//  public String getSmallIconURL() {
//    return smallIconURL;
//  }
//
//  public void setSmallIconURL(String smallIconURL) {
//    this.smallIconURL = smallIconURL;
//  }
//
//  public String getMediumIconURL() {
//    return mediumIconURL;
//  }
//
//  public void setMediumIconURL(String mediumIconURL) {
//    this.mediumIconURL = mediumIconURL;
//  }
//
//  public String getLargeIconURL() {
//    return largeIconURL;
//  }
//
//  public void setLargeIconURL(String largeIconURL) {
//    this.largeIconURL = largeIconURL;
//  }
//
//  public Category getCategory() {
//    return category;
//  }
//
//  public void setCategory(Category category) {
//    this.category = category;
//  }
//
//  public Style getStyle() {
//    return style;
//  }
//
//  public void setStyle(Style style) {
//    this.style = style;
//  }
//
//  public Glass getGlass() {
//    return glass;
//  }
//
//  public void setGlass(Glass glass) {
//    this.glass = glass;
//  }

  @Override
  public String toString() {
    return "BeerResponse{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", abv=" + abv +
//        ", isOrganic=" + isOrganic +
//        ", isRetired=" + isRetired +
//        ", smallIconURL='" + smallIconURL + '\'' +
//        ", mediumIconURL='" + mediumIconURL + '\'' +
//        ", largeIconURL='" + largeIconURL + '\'' +
//        ", category=" + category +
//        ", style=" + style +
//        ", glass=" + glass +
        '}';
  }
}