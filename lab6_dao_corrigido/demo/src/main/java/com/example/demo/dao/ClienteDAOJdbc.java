package com.example.demo.dao;

import com.example.demo.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOJdbc implements ClienteDAO {

    private Connection conn;

    public ClienteDAOJdbc(Connection conn) throws Exception {
        this.conn = conn;

        Statement stmt = conn.createStatement();
        stmt.execute(
            "CREATE TABLE IF NOT EXISTS cliente (" +
            "id SERIAL PRIMARY KEY," +
            "nome VARCHAR(100)," +
            "email VARCHAR(100))"
        );
    }

    @Override
    public void inserir(Cliente c) throws Exception {
        String sql = "INSERT INTO cliente(nome,email) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getEmail());
        stmt.executeUpdate();
    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            lista.add(new Cliente(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("email")
            ));
        }

        return lista;
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        String sql = "UPDATE cliente SET nome=?, email=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getEmail());
        stmt.setLong(3, c.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deletar(Long id) throws Exception {
        String sql = "DELETE FROM cliente WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.executeUpdate();
    }
}