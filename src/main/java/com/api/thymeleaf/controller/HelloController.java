package com.api.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("nome", "sdasdfafafas");
        return "hello";
    }

//    @GetMapping("/hello")
//    public ModelAndView extractLabels(String name, ModelMap map) {
//        map.addAttribute("name", "testez");
//        return new ModelAndView("hello", map);
//    }
}
