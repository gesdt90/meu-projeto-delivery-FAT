package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Cadastrar
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id,
                             @RequestBody Produto produto) {
        return service.atualizar(id, produto);
    }

    // Excluir
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    // Buscar produtos por restaurante
    @GetMapping("/restaurante/{restauranteId}")
    public List<Produto> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return service.buscarPorRestaurante(restauranteId);
    }
}