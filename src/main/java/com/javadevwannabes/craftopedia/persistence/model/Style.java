package com.javadevwannabes.craftopedia.persistence.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "styles")
public class Style {

  @Id
  @Column(name = "style_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  private String styleName;

  private String styleShortName;

  private String styleDescription;

  @OneToMany(mappedBy = "style", cascade = CascadeType.ALL)
  private List<Beer> beers;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id")
  private Category category;

  public Style(@NotNull String styleName, String styleShortName, String styleDescription,
      List<Beer> beers, Category category) {
    this.styleName = styleName;
    this.styleShortName = styleShortName;
    this.styleDescription = styleDescription;
    this.beers = beers;
    this.category = category;
  }

  public Style() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStyleName() {
    return styleName;
  }

  public void setStyleName(String styleName) {
    this.styleName = styleName;
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

  public List<Beer> getBeers() {
    return beers;
  }

  public void setBeers(List<Beer> beers) {
    this.beers = beers;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
