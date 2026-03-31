package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ClienteDAO;
import com.example.demo.dao.ClienteDAOJdbc;
import com.example.demo.model.Cliente;

import com.example.demo.dao.PedidoDAO;
import com.example.demo.dao.PedidoDAOJdbc;
import com.example.demo.model.Pedido;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
	@Override
public void run(String... args) throws Exception {

    Connection conn = DriverManager.getConnection(
        "jdbc:postgresql://db.kpgpidlidbfpiokpdmev.supabase.co:5432/postgres",
        "postgres",
        "Lab6DAO!..."
    );

    ClienteDAO clienteDAO = new ClienteDAOJdbc(conn);
    PedidoDAO pedidoDAO = new PedidoDAOJdbc(conn);

    
    clienteDAO.inserir(new Cliente(null, "Lara", "lara@email.com"));

    System.out.println("Clientes:");
    for (Cliente c : clienteDAO.listar()) {
        System.out.println(c.getId() + " - " + c.getNome());
    }

    pedidoDAO.inserir(new Pedido(null, 1L, 150.0));

    System.out.println("\nPedidos:");
    for (Pedido p : pedidoDAO.listar()) {
        System.out.println(
            p.getId() + " - Cliente: " + p.getClienteId() +
            " - Valor: " + p.getValorTotal()
        );
    }
}
}   