package com.api.thymeleaf.controller;

import com.api.thymeleaf.dto.PedidoDTO;
import com.api.thymeleaf.service.HomeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collections;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    HomeService service;

    @GetMapping
    public String home(@Valid PedidoDTO pedidoDTO, Model model) {
        model.addAttribute("pedidos", Collections.singletonList(service.getPedidos(pedidoDTO)));
        return "home";
    }
}
