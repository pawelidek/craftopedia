//package com.javadevwannabes.craftopedia.domain;
//
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "categories")
//public class Category {
//
//  @Id
//  @Column(name = "category_id")
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private int id;
//
//  @NotNull
//  private String name;
//
//  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//  private List<Beer> beers;
//
//  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//  private List<Style> styles;
//
//  public Category(@NotNull String name,
//      List<Beer> beers, List<Style> styles) {
//    this.name = name;
//    this.beers = beers;
//    this.styles = styles;
//  }
//
//  public Category() {
//  }
//
//  public int getId() {
//    return id;
//  }
//
//  public void setId(int id) {
//    this.id = id;
//  }
//
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public List<Beer> getBeers() {
//    return beers;
//  }
//
//  public void setBeers(List<Beer> beers) {
//    this.beers = beers;
//  }
//
//  public List<Style> getStyles() {
//    return styles;
//  }
//
//  public void setStyles(List<Style> styles) {
//    this.styles = styles;
//  }
//}
