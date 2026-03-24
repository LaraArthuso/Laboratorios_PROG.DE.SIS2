package com.example.demo.dao;

import com.example.demo.model.Pedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import jakarta.annotation.PostConstruct;

@Repository
public class PedidoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.execute(
            "CREATE TABLE IF NOT EXISTS pedido (" +
            "id SERIAL PRIMARY KEY," +
            "cliente_id BIGINT," +
            "valor_total DOUBLE PRECISION)"
        );
    }

    public List<Pedido> listar() {
        return jdbcTemplate.query(
            "SELECT * FROM pedido",
            new BeanPropertyRowMapper<>(Pedido.class)
        );
    }

    public void inserir(Pedido p) {
        jdbcTemplate.update(
            "INSERT INTO pedido(cliente_id, valor_total) VALUES (?, ?)",
            p.getCliente_id(), p.getValor_total()
        );
    }
}