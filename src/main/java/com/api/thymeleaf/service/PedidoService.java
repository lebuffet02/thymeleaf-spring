package com.api.thymeleaf.service;

import com.api.thymeleaf.dto.PedidoDTO;
import com.api.thymeleaf.entity.PedidoEntity;
import com.api.thymeleaf.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public void getPedido(PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setNome(pedidoDTO.getNome());
        pedidoEntity.setDescricao(pedidoDTO.getDescricao());
        pedidoEntity.setUrlProduto(pedidoDTO.getUrlProduto());
        pedidoEntity.setUrl(pedidoDTO.getUrl());

    }
}
