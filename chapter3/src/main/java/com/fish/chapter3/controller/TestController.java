package com.fish.chapter3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

  /**
   * 方案一
   * @param model
   * @return
   */
  @GetMapping("index1")
  public String index(Model model) {
    model.addAttribute("id", "1");
    model.addAttribute("title", "SpringBoot Thymeleaf");
    model.addAttribute("author", "Java程序鱼");
    return "index1";
  }

  /**
   * 方案二
   * @return
   */
  @GetMapping("index2")
  public Object index2() {
    ModelAndView modelAndView = new ModelAndView("/index2");

    modelAndView.addObject("id", "2");
    modelAndView.addObject("title", "SpringBoot Thymeleaf2");
    modelAndView.addObject("author", "Java程序鱼");
    return modelAndView;
  }

  /**
   * 方案三
   * @param modelMap
   * @return
   */
  @GetMapping("index3")
  public String index3(ModelMap modelMap) {
    modelMap.addAttribute("id", "3");
    modelMap.addAttribute("title", "SpringBoot Thymeleaf3");
    modelMap.addAttribute("author", "Java程序鱼");
    return "index3";
  }
}
