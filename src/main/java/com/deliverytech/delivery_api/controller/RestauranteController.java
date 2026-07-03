package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Restaurante> listar() {
        return service.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Cadastrar
    @PostMapping
    public Restaurante cadastrar(@RequestBody Restaurante restaurante) {
        return service.salvar(restaurante);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Restaurante atualizar(@PathVariable Long id,
                                 @RequestBody Restaurante restaurante) {
        return service.atualizar(id, restaurante);
    }

    // Inativar
    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id) {
        service.inativar(id);
    }

    // Ativar
    @PatchMapping("/{id}/ativar")
    public void ativar(@PathVariable Long id) {
        service.ativar(id);
    }
}