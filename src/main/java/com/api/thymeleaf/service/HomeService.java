//package com.api.thymeleaf.service;
//
//import com.api.thymeleaf.constants.SetorConstantes;
//import com.api.thymeleaf.dto.PedidoDTO;
//import com.api.thymeleaf.repository.PedidoRepository;
//import com.fasterxml.jackson.databind.cfg.MapperConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class HomeService {
//
//    @Autowired
//    PedidoRepository repository;
//    @Autowired
//    MapperConfig mapper;
//
//
//    public List<PedidoDTO> getPedidos() {
//        return repository.findAll()
//                .stream()
//                .map(p -> mapper.MapperUtils().map(p, PedidoDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public List<PedidoDTO> getPedidoByStatus(String status) {
//            return repository.findByStatus(SetorConstantes.valueOf(status.toUpperCase())).stream().map(p -> mapper.MapperUtils().map(p, PedidoDTO.class)).collect(Collectors.toList());
//    }
//}