package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.Pedido;

public interface PedidoDAO {

    void inserir(Pedido p) throws Exception;

    List<Pedido> listar() throws Exception;

    void deletar(Long id) throws Exception;
}
