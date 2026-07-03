package com.deliverytech.delivery_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private Double valorTotal;

    private LocalDateTime dataPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {
        this.dataPedido = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}