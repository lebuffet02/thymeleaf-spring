package com.api.thymeleaf.controller;

import com.api.thymeleaf.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    HomeService service;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("pedidos", service.getPedidos());
        return "home";
    }

    @GetMapping("/{status}")
    public String getStatus(@PathVariable("status") String status, Model model) {
        model.addAttribute("pedidos", service.getPedidoByStatus(status));
        model.addAttribute("status", status);
        return "home";
    }

//    @GetMapping
//    public ModelAndView home() {
//        ModelAndView mv = new ModelAndView("home");
//        mv.addObject("pedidos", service.getPedidos());
//        return mv;
//    }
}
