package com.javadevwannabes.craftopedia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticlesContoller {

  @GetMapping("/articles")
  public String homePage(Model model) {
    return "articles";
  }
}