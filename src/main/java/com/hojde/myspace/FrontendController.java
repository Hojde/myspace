package com.hojde.myspace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

  @Value("${app.mode}")
  private String profile;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("appMode", profile);
    return "index";
  }
}
