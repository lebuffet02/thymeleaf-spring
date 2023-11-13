package com.api.thymeleaf.service;

import com.api.thymeleaf.config.MapperConfig;
import com.api.thymeleaf.dto.PedidoDTO;
import com.api.thymeleaf.entity.PedidoEntity;
import com.api.thymeleaf.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;
    @Autowired
    MapperConfig mapper;

    public PedidoDTO getPedido(PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setNome(pedidoDTO.getNome());
        pedidoEntity.setDescricao(pedidoDTO.getDescricao());
        pedidoEntity.setUrlProduto(pedidoDTO.getUrlProduto());
        pedidoEntity.setUrl(pedidoDTO.getUrl());
        repository.save(pedidoEntity);
        return mapper.MapperUtils().map(pedidoEntity, PedidoDTO.class);
    }
}

