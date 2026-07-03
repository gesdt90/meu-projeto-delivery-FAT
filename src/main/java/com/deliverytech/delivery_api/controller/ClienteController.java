package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Cadastrar
    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id,
                             @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }

    // Inativar (DELETE lógico)
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.inativar(id);
    }
}