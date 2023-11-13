package com.api.thymeleaf.repository;

import com.api.thymeleaf.constants.StatusPedido;
import com.api.thymeleaf.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByStatus(StatusPedido aguardando);
}
