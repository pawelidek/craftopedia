package com.javadevwannabes.craftopedia.controller;


import com.javadevwannabes.craftopedia.persistence.model.User;
import com.javadevwannabes.craftopedia.dto.UserDto;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

  private final Logger LOGGER = LoggerFactory.getLogger(getClass());

  @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
  public String showRegistrationForm(final HttpServletRequest request, final Model model) {
    LOGGER.debug("Rendering registration page.");
    final UserDto accountDto = new UserDto();
    model.addAttribute("user", accountDto);
    return "registration";
  }

  @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
  public ModelAndView registerUserAccount(
      @ModelAttribute("user") @Valid UserDto accountDto,
      BindingResult result, WebRequest request, Errors errors) {
    User registered = new User();

    return new ModelAndView();
  }


}
