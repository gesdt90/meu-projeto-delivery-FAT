package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // Criar pedido
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return service.processarPedido(pedido);
    }

    // Listar todos
    @GetMapping
    public List<Pedido> listarPedidos() {
        return service.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Atualizar status
    @PatchMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id,
                                  @RequestParam String status) {
        return service.atualizarStatus(id, status);
    }
}