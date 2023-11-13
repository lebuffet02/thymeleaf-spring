package com.api.thymeleaf.service;

import com.api.thymeleaf.config.MapperConfig;
import com.api.thymeleaf.constants.StatusPedido;
import com.api.thymeleaf.dto.PedidoDTO;
import com.api.thymeleaf.entity.PedidoEntity;
import com.api.thymeleaf.exception.ThymeleafException;
import com.api.thymeleaf.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

    @Autowired
    PedidoRepository repository;
    @Autowired
    MapperConfig mapper;

    public List<PedidoDTO> getPedidos() {
        try {
            return repository.findAll()
                    .stream()
                    .map(p -> mapper.MapperUtils().map(p, PedidoDTO.class))
                    .collect(Collectors.toList());
        } catch (ThymeleafException e) {
                throw new ThymeleafException(e.getMessage());
        }
    }

    public List<PedidoDTO> getPedidoByStatus(String status) {
        try {
            List<PedidoEntity> pedidoEntity = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
            return !CollectionUtils.isEmpty(pedidoEntity) ?
                    pedidoEntity
                            .stream()
                            .map(p -> mapper.MapperUtils().map(p, PedidoDTO.class))
                            .collect(Collectors.toList()) : new ArrayList<>();
        } catch (ThymeleafException e) {
            throw new ThymeleafException(e.getMessage());
        }
    }
}