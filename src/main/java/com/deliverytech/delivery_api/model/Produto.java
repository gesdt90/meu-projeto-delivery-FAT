package com.deliverytech.delivery_api.model;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    private Double preco;

    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    public Produto() {
    }

    public Produto(String nome, String categoria, Double preco, boolean disponivel, Restaurante restaurante) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.disponivel = disponivel;
        this.restaurante = restaurante;
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

    public Double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}