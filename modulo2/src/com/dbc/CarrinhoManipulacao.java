package com.dbc;

import com.dbc.model.Produto_Cliente;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoManipulacao{

    private List<Produto_Cliente> listaDeProdutoCliente;

    public CarrinhoManipulacao() {
        this.listaDeProdutoCliente = new ArrayList<>();
    }

    public void adicionarCarrinho(Produto_Cliente produtoCliente) {
        this.listaDeProdutoCliente.add(produtoCliente);
    }

    public void removerCarrinhoPorIndice(Integer index) {
        this.listaDeProdutoCliente.remove(index.intValue());
    }

    public void editarCarrinho(Integer index, Produto_Cliente produtoCliente) {
        Produto_Cliente produtoClienteProcurado = listaDeProdutoCliente.get(index);
        produtoClienteProcurado.setProdutos(produtoCliente.getProdutos());
        produtoClienteProcurado.setCupom(produtoCliente.getCupom());
    }

    public void listarCarrinho() {
        for (int i = 0; i < listaDeProdutoCliente.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeProdutoCliente.get(i));
        }
    }

    public boolean isEmpty() {
        return this.listaDeProdutoCliente.isEmpty();
    }
}