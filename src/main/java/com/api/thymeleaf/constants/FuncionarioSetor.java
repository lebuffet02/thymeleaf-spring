package com.api.thymeleaf.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuncionarioSetor {

    ADMINISTRATIVO("Administrativo"), RH("RH"), TECNOLOGIA("Tecnologia");

    private final String value;
}
