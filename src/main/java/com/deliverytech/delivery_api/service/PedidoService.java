package com.deliverytech.delivery_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Transactional
    public void processarPedido() {

        System.out.println("Pedido processado com sucesso!");

    }
}