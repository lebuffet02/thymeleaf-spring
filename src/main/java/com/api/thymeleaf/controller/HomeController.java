package com.api.thymeleaf.controller;

import com.api.thymeleaf.constants.FuncionarioSetor;
import com.api.thymeleaf.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private FuncionarioRepository funcRepository;


//    @GetMapping
//    public ModelAndView home() {
//        ModelAndView mv = new ModelAndView("home");
//        mv.addObject("pedidos", service.getPedidos());
//        return mv;
//    }


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("funcionarios", funcRepository.findAll());
        return "home";
    }

    @GetMapping
    public String setor(@RequestParam("setor") String setor, Model model) {
        FuncionarioSetor funcionarioSetor = FuncionarioSetor.valueOf(setor.toUpperCase());
        model.addAttribute("funcionarios", funcRepository.findBySetor(funcionarioSetor));
        return "home";
    }

    @GetMapping("tela-inicial")
    public String redirecionar() {
        return "redirect:/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String getError() {
        return "redirect:/home";
    }
}
