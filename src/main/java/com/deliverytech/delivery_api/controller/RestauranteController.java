package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

@RestController
public class RestauranteController {

    private final RestauranteRepository repository;

    public RestauranteController(RestauranteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/restaurantes")
    public List<Restaurante> listar() {
        return repository.findAll();
    }
}