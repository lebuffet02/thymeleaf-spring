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

    private static final String MESSAGE_KEY = "Usuário inválido para esse ID";

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
    public String atualizarForm(
            @PathVariable("id") Long id, Model model) {
        Funcionario funcionario = funcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_KEY.concat(": ") + id));
        model.addAttribute("funcionario", funcionario);
        return "atualizaForm";
    }

    @PostMapping("update/{id}")
    public String alterarProduto(
            @PathVariable("id") Long id,
            @Valid Funcionario funcionario, BindingResult result) {
        if (!result.hasErrors()) {
            funcRepository.save(funcionario);
            return "redirect:/home";
        }
        return "redirect:/form";
    }

    @GetMapping("delete/{id}")
    @CacheEvict(value = "funcionarios", allEntries = true)
    public String delete(
            @PathVariable("id") Long id, Model model) {
        Funcionario funcionario = funcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_KEY.concat(": ") + id));
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
