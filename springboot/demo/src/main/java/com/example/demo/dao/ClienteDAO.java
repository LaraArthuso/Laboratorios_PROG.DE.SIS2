
package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import jakarta.annotation.PostConstruct;
import com.example.demo.model.Cliente;
@Repository


public class ClienteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.execute(
            "CREATE TABLE IF NOT EXISTS cliente (" +
            "id SERIAL PRIMARY KEY," +
            "nome VARCHAR(100)," +
            "email VARCHAR(100))"
        );
    }

    public List<Cliente> listar() {
        return jdbcTemplate.query(
            "SELECT * FROM cliente",
            new BeanPropertyRowMapper<>(Cliente.class)
        );
    }

    public void inserir(Cliente c) {
        jdbcTemplate.update(
            "INSERT INTO cliente(nome,email) VALUES (?, ?)",
            c.getNome(), c.getEmail()
        );
    }

}