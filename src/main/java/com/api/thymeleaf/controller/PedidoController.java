package com.api.thymeleaf.controller;

import com.api.thymeleaf.dto.PedidoDTO;
import com.api.thymeleaf.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @GetMapping
    public String formulario() {
        return "pedido/formulario";
    }

    @PostMapping
    public String novo(@RequestBody @Valid PedidoDTO pedidoDTO) {
        service.getPedido(pedidoDTO);
        return "pedido/formulario";
    }
}
