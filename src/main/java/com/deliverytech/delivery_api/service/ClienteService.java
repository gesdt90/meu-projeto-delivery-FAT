package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.exception.RecursoNaoEncontradoException;
import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // Listar todos
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Cliente não encontrado."));
    }

    // Salvar
    public Cliente salvar(Cliente cliente) {

        if (repository.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        return repository.save(cliente);
    }

    // Atualizar
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {

        Cliente cliente = buscarPorId(id);

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setAtivo(clienteAtualizado.isAtivo());

        return repository.save(cliente);
    }

    // Inativar
    public void inativar(Long id) {

        Cliente cliente = buscarPorId(id);

        cliente.setAtivo(false);

        repository.save(cliente);
    }
}