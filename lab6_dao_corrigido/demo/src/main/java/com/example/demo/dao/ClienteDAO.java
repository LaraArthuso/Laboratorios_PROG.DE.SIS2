package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.Cliente;

public interface ClienteDAO {

    void inserir(Cliente c) throws Exception;

    List<Cliente> listar() throws Exception;

    void atualizar(Cliente c) throws Exception;

    void deletar(Long id) throws Exception;
}