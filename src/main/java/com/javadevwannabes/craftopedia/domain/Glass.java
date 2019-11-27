//package com.javadevwannabes.craftopedia.domain;
//
//import java.util.ArrayList;
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
//@Table(name = "glassware")
//public class Glass {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "glass_id")
//  private Long glassId;
//
//  @Column(name = "name")
//  private String name;
//
//  @OneToMany(mappedBy = "glass", cascade = CascadeType.ALL)
//  private List<Beer> beers = new ArrayList<>();
//
//  public Glass(@NotNull String name,
//      List<Beer> beers) {
//    this.name = name;
//    this.beers = beers;
//  }
//
//  public Glass() {
//  }
//
//  public Long getGlassId() {
//    return glassId;
//  }
//
//  public void setGlassId(Long glassId) {
//    this.glassId = glassId;
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
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//}
