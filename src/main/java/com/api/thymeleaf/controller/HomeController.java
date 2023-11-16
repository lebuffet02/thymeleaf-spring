package com.api.thymeleaf.controller;

import com.api.thymeleaf.constants.FuncionarioSetor;
import com.api.thymeleaf.entity.Funcionario;
import com.api.thymeleaf.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FuncionarioRepository funcRepository;


    @GetMapping("/home")
    public String home(Model model) {
        List<Funcionario> funcionarios = funcRepository.findAll();

        model.addAttribute("funcionarios", funcionarios);
        return "home";
    }

    //    @GetMapping
//    public ModelAndView home() {
//        ModelAndView mv = new ModelAndView("home");
//        mv.addObject("pedidos", service.getPedidos());
//        return mv;
//    }


    @GetMapping
    public String setor(@RequestParam String setor, Model model) {
        FuncionarioSetor funcionarioSetor = FuncionarioSetor.valueOf(setor.toUpperCase());
        List<Funcionario> funcionarios = funcRepository.findBySetor(funcionarioSetor);

        model.addAttribute("funcionarios", funcionarios);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String getError() {
        return "redirect:/home";
    }
}
