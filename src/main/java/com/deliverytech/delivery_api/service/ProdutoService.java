package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.exception.RecursoNaoEncontradoException;
import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Produto não encontrado."));
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {

        Produto produto = buscarPorId(id);

        produto.setNome(produtoAtualizado.getNome());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setDisponivel(produtoAtualizado.isDisponivel());
        produto.setRestaurante(produtoAtualizado.getRestaurante());

        return repository.save(produto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<Produto> buscarPorRestaurante(Long restauranteId) {
        return repository.findByRestauranteId(restauranteId);
    }
}