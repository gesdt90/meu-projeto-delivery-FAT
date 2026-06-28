package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;

    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }

    public List<Restaurante> listarTodos() {
        return repository.findAll();
    }

    public Restaurante salvar(Restaurante restaurante) {
        return repository.save(restaurante);
    }
    public Restaurante buscarPorId(Long id) {
    return repository.findById(id).orElse(null);
    }
    
}