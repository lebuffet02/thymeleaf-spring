package com.api.thymeleaf.entity;

import com.api.thymeleaf.constants.FuncionarioSetor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity(name = "FuncionarioEntity")
@Table(name = "FUNCIONARIOS")
@Getter
@Setter
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
    private double salario;

    @Column(name = "dataContratacao")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Instant dataContratacao = Instant.now();

    @Enumerated(EnumType.STRING)
    private FuncionarioSetor setor;
}
