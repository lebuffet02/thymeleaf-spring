package com.api.thymeleaf.service;

import com.api.thymeleaf.dto.PedidoDTO;
import com.api.thymeleaf.entity.PedidoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    ModelMapper mapper;

    public PedidoDTO getPedidos(PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setNome(pedidoDTO.getNome());
        pedidoEntity.setDescricao(pedidoDTO.getDescricao());
        pedidoEntity.setUrlProduto(pedidoDTO.getUrlProduto());
        pedidoEntity.setUrl(pedidoDTO.getUrl());
        return mapper.map(pedidoEntity, PedidoDTO.class);
    }
}
