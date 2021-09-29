package com.fish.chapter3.controller;

import com.fish.chapter3.domain.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BlogController {

  @GetMapping("each")
  public String each(Model model) {
    ArrayList<Blog> list = new ArrayList<>();
    list.add(new Blog(1, "each1", "java程序鱼1"));
    list.add(new Blog(2, "each2", "java程序鱼2"));
    list.add(new Blog(3, "each3", "java程序鱼3"));

    model.addAttribute("list", list);
    return "each";
  }

  @GetMapping("if")
  public String ifHtml(Model model) {
    model.addAttribute("id", 1);
    return "if";
  }

  @GetMapping("include")
  public String include() {
    return "include";
  }
}
