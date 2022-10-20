package com.dbc.vemser.trabalhofinal.pokestore.service;

import com.dbc.vemser.trabalhofinal.pokestore.exceptions.*;
import com.dbc.vemser.trabalhofinal.pokestore.model.Cupom;
import com.dbc.vemser.trabalhofinal.pokestore.model.Pedido;
import com.dbc.vemser.trabalhofinal.pokestore.model.ProdutoPedido;
import com.dbc.vemser.trabalhofinal.pokestore.repository.PedidoRepository;
import com.dbc.vemser.trabalhofinal.pokestore.repository.ProdutoPedidoRepository;

import java.util.List;

public class PedidoService {
    private PedidoRepository pedidoRepository;

    private ProdutoPedidoRepository produtoPedidoRepository;

    public PedidoService() {
        pedidoRepository = new PedidoRepository();
        produtoPedidoRepository = new ProdutoPedidoRepository();
    }

    // criação de um objeto
    public Pedido adicionarPedido(Pedido pedido) { // vai adicionar tudo dentro da tabela N para N (Pedido_Produto)
        try {
            Double valorFinalPedido = calcularValorFinal(pedido);
            pedido.setValorFinal(valorFinalPedido);
            Pedido pedidoAdicionado = pedidoRepository.adicionar(pedido);
            for (ProdutoPedido produtoPedido : pedidoAdicionado.getProdutosPedido()) {
                produtoPedido.setPedido(pedidoAdicionado);
                produtoPedidoRepository.adicionar(produtoPedido);
            }
            System.out.println("Pedido adicionado com sucesso! " + pedidoAdicionado);
            return pedidoAdicionado;
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Calculo valor final
    public double calcularValorFinal(Pedido pedido) { // mudar para service
        if (pedido.getProdutosPedido().size() > 0) {
            double valorFinal = 0;
            for (ProdutoPedido value : pedido.getProdutosPedido()) {
                valorFinal += value.getValor();
            }
            if (pedido.getCupom() != null && pedido.getCupom().getDeletado().equals("F")) {
                valorFinal = valorFinal - pedido.getCupom().getValor();
            }
            return valorFinal;
        }
        return 0;
    }

    public Pedido inserirCupom(Cupom cupom, Pedido pedido){
        try {
            pedido.setCupom(cupom);
            pedidoRepository.atualizarCupom(pedido.getCupom().getIdCupom(),pedido);
            pedidoRepository.editar(pedido.getIdPedido(),pedido);.
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
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
