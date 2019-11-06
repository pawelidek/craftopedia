package com.javadevwannabes.craftopedia.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "beers")
public class Beer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String name;

  private String description;

  private double abv;

  private boolean isOrganic;

  private boolean isRetired;

  private String smallIconURL;

  private String mediumIconURL;

  private String largeIconURL;

  public Beer(@NotNull String name, String description, double abv, boolean isOrganic,
      boolean isRetired, String smallIconURL, String mediumIconURL, String largeIconURL) {
    this.name = name;
    this.description = description;
    this.abv = abv;
    this.isOrganic = isOrganic;
    this.isRetired = isRetired;
    this.smallIconURL = smallIconURL;
    this.mediumIconURL = mediumIconURL;
    this.largeIconURL = largeIconURL;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public boolean isOrganic() {
    return isOrganic;
  }

  public void setOrganic(boolean organic) {
    isOrganic = organic;
  }

  public boolean isRetired() {
    return isRetired;
  }

  public void setRetired(boolean retired) {
    isRetired = retired;
  }

  public String getSmallIconURL() {
    return smallIconURL;
  }

  public void setSmallIconURL(String smallIconURL) {
    this.smallIconURL = smallIconURL;
  }

  public String getMediumIconURL() {
    return mediumIconURL;
  }

  public void setMediumIconURL(String mediumIconURL) {
    this.mediumIconURL = mediumIconURL;
  }

  public String getLargeIconURL() {
    return largeIconURL;
  }

  public void setLargeIconURL(String largeIconURL) {
    this.largeIconURL = largeIconURL;
  }
}
