package com.api.thymeleaf.entity;

import com.api.thymeleaf.constants.FuncionarioSetor;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "FuncionarioEntity")
@Table(name = "FUNCIONARIOS")
@Data
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "dataContratacao")
    private LocalDateTime dataContratacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private FuncionarioSetor setor;

}
