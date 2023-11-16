//package com.api.thymeleaf.service;
//
//import com.api.thymeleaf.constants.SetorConstantes;
//import com.api.thymeleaf.dto.PedidoDTO;
//import com.api.thymeleaf.entity.Funcionario;
//import com.api.thymeleaf.repository.PedidoRepository;
//import com.fasterxml.jackson.databind.cfg.MapperConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class PedidoService {
//
//    @Autowired
//    PedidoRepository repository;
//    @Autowired
//    MapperConfig mapper;
//
//    public void getPedido(PedidoDTO pedidoDTO) {
//        Optional<Funcionario> pedidoEntity = Optional.of(new Funcionario());
//        pedidoEntity.get().setNome(pedidoDTO.getNome());
//        pedidoEntity.get().setDescricao(pedidoDTO.getDescricao());
//        pedidoEntity.get().setUrlProduto(pedidoDTO.getUrlProduto());
//        pedidoEntity.get().setUrl(pedidoDTO.getUrl());
//        pedidoEntity.get().setStatus(SetorConstantes.AGUARDANDO);
//        repository.save(pedidoEntity.get());
//        mapper.MapperUtils().map(pedidoEntity, PedidoDTO.class);
//    }
//}
//
