package com.example.demo.dao;

import com.example.demo.model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOJdbc implements PedidoDAO {

    private Connection conn;

    public PedidoDAOJdbc(Connection conn) throws Exception {
        this.conn = conn;

        Statement stmt = conn.createStatement();
        stmt.execute(
            "CREATE TABLE IF NOT EXISTS pedido (" +
            "id SERIAL PRIMARY KEY," +
            "cliente_id BIGINT," +
            "valor_total DOUBLE PRECISION," +
            "FOREIGN KEY (cliente_id) REFERENCES cliente(id)" +
            ")"
        );
    }

    @Override
    public void inserir(Pedido p) throws Exception {
        String sql = "INSERT INTO pedido(cliente_id, valor_total) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, p.getClienteId());
        stmt.setDouble(2, p.getValorTotal());
        stmt.executeUpdate();
    }

    @Override
    public List<Pedido> listar() throws Exception {
        List<Pedido> lista = new ArrayList<>();

        String sql = "SELECT * FROM pedido";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            lista.add(new Pedido(
                rs.getLong("id"),
                rs.getLong("cliente_id"),
                rs.getDouble("valor_total")
            ));
        }

        return lista;
    }

    @Override
    public void deletar(Long id) throws Exception {
        String sql = "DELETE FROM pedido WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.executeUpdate();
    }
}
