package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ClienteDAO;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteDAO dao;

    @GetMapping
    public List<Cliente> listar() {
        return dao.listar();
    }

    @PostMapping
    public void inserir(@RequestBody Cliente c) {
        dao.inserir(c);
    }
}