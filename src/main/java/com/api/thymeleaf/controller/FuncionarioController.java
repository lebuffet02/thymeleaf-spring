package com.api.thymeleaf.controller;

import com.api.thymeleaf.entity.Funcionario;
import com.api.thymeleaf.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcRepository;


    @GetMapping("/form")
    public String funcionariosForm(Funcionario funcionario) {
        return "addFuncionariosForm";
    }

    @PostMapping("/add")
    public String novo(@Valid Funcionario funcionario, BindingResult result) {
        getErrors(result);
        funcRepository.save(funcionario);
        return "redirect:/home";
    }

    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable("id") Long id) {

        Funcionario funcionario = funcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("funcionario", funcionario);
        return "atualizaForm";
    }

    @PostMapping("update/{id}")
    public String alterarProduto(@Valid Funcionario funcionario, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "redirect:/form";
        }
        funcRepository.save(funcionario);
        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    @CacheEvict(value = "funcionarios", allEntries = true)
    public String delete(@PathVariable("id") Long id, Model model) {
        Funcionario funcionario = funcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        funcRepository.delete(funcionario);
        return "redirect:/home";
    }

    private String getErrors(BindingResult result) {
        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }
        return "";
    }
}
