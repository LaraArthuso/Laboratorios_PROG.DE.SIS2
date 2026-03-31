 package com.example.demo.model;

public class Pedido {

    private Long id;
    private Long clienteId;
    private Double valorTotal;

    public Pedido() {}

    public Pedido(Long id, Long clienteId, Double valorTotal) {
        this.id = id;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}

