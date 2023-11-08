package com.api.thymeleaf.entity;

import com.api.thymeleaf.constants.StatusPedido;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "PedidosEntity")
@Table(name = "PRODUTOS")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PedidoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "dataEntrega")
    private LocalDate dataEntrega;

    @Column(name = "urlProduto")
    private String urlProduto;

    @Column(name = "url")
    private String url;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
