package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.service.RestauranteService;

@RestController
public class RestauranteController {

    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    @GetMapping("/restaurantes")
    public List<Restaurante> listar() {
        return service.listarTodos();
    }

    @GetMapping("/restaurantes/{id}")
    public Restaurante buscarPorId(@PathVariable Long id) {
    return service.buscarPorId(id);
    }

    @PostMapping("/restaurantes")
    public Restaurante cadastrar(@RequestBody Restaurante restaurante) {
    return service.salvar(restaurante);
    }
    
}