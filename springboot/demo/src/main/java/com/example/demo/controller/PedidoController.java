package com.example.demo.controller;

import com.example.demo.dao.PedidoDAO;
import com.example.demo.model.Pedido;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoDAO dao;

    @GetMapping
    public List<Pedido> listar() {
        return dao.listar();
    }

    @PostMapping
    public void inserir(@RequestBody Pedido p) {
        dao.inserir(p);
    }
}