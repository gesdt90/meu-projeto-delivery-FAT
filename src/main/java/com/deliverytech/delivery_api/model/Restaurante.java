package com.deliverytech.delivery_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    private Double avaliacao;

    private boolean ativo;

    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos;

    public Restaurante() {
    }

    public Restaurante(String nome, String categoria, Double avaliacao, boolean ativo) {
        this.nome = nome;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}