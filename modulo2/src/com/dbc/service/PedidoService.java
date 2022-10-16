package com.dbc.service;

import com.dbc.exceptions.*;
import com.dbc.model.Pedido;
import com.dbc.repository.PedidoRepository;

import java.util.List;

public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService() {
        pedidoRepository = new PedidoRepository();
    }

    // criação de um objeto
    public void adicionarPedido(Pedido pedido) {
        try {
            Pedido pedidoAdicionado = pedidoRepository.adicionar(pedido);
            System.out.println("Pedido adicionado com sucesso! " + pedidoAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    // remoção
    public void removerPedido(Integer id) {
        try {
            boolean conseguiuRemover = pedidoRepository.remover(id);
            System.out.println("Pedido removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarPedido(Integer id, Pedido pedido) {
        try {
            boolean conseguiuEditar = pedidoRepository.editar(id, pedido);
            System.out.println("Pedido editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarPedido() {
        try {
            List<Pedido> listar = pedidoRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
