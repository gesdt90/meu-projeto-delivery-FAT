package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.exception.RecursoNaoEncontradoException;
import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;

    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }

    // Listar todos
    public List<Restaurante> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public Restaurante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Restaurante não encontrado."));
    }

    // Cadastrar
    public Restaurante salvar(Restaurante restaurante) {

        if (restaurante.getNome() == null || restaurante.getNome().isBlank()) {
            throw new RuntimeException("O nome do restaurante é obrigatório.");
        }

        return repository.save(restaurante);
    }

    // Atualizar
    public Restaurante atualizar(Long id, Restaurante restauranteAtualizado) {

        Restaurante restaurante = buscarPorId(id);

        restaurante.setNome(restauranteAtualizado.getNome());
        restaurante.setCategoria(restauranteAtualizado.getCategoria());
        restaurante.setAvaliacao(restauranteAtualizado.getAvaliacao());
        restaurante.setAtivo(restauranteAtualizado.isAtivo());

        return repository.save(restaurante);
    }

    // Inativar
    public void inativar(Long id) {

        Restaurante restaurante = buscarPorId(id);

        restaurante.setAtivo(false);

        repository.save(restaurante);
    }

    // Ativar
    public void ativar(Long id) {

        Restaurante restaurante = buscarPorId(id);

        restaurante.setAtivo(true);

        repository.save(restaurante);
    }
}