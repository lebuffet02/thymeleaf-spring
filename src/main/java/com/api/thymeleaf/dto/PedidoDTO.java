package com.api.thymeleaf.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoDTO {

    private String nome;
    private String descricao;
    private String urlProduto;
    private String url;
}
