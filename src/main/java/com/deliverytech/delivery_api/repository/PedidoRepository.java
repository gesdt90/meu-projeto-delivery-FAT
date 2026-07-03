package com.deliverytech.delivery_api.repository;

import com.deliverytech.delivery_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByStatus(String status);

    List<Pedido> findByDataPedidoBetween(LocalDateTime inicio, LocalDateTime fim);

}