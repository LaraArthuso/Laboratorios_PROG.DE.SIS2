package com.example.demo.model;

public class Pedido {
    private Long id;
    private Long cliente_id;
    private Double valor_total;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCliente_id() { return cliente_id; }
    public void setCliente_id(Long cliente_id) { this.cliente_id = cliente_id; }

    public Double getValor_total() { return valor_total; }
    public void setValor_total(Double valor_total) { this.valor_total = valor_total; }
}