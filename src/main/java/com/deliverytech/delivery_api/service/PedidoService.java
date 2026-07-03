package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliverytech.delivery_api.exception.PedidoInvalidoException;
import com.deliverytech.delivery_api.exception.RecursoNaoEncontradoException;
import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Pedido processarPedido(Pedido pedido) {

        if (pedido == null) {
            throw new PedidoInvalidoException("Pedido não pode ser nulo.");
        }

        if (pedido.getValorTotal() == null || pedido.getValorTotal() <= 0) {
            throw new PedidoInvalidoException("O valor do pedido deve ser maior que zero.");
        }

        pedido.setStatus("PENDENTE");

        return repository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Pedido não encontrado. ID: " + id));
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Pedido atualizarStatus(Long id, String status) {

        Pedido pedido = buscarPorId(id);

        pedido.setStatus(status);

        return repository.save(pedido);
    }
}