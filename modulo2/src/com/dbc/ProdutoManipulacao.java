package com.dbc;

import com.dbc.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;

public class ProdutoManipulacao {

    private final List<Produto> listaDeProdutos;

    public ProdutoManipulacao() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.listaDeProdutos.add(produto);
    }

    public void removerProdutoPorIndice(Integer index) {
        this.listaDeProdutos.remove(index.intValue());
    }

    public void editarProduto(Integer index, Produto produto) {
        Produto produtoProcurado = listaDeProdutos.get(index);
        produtoProcurado.setNome(produto.getNome());
        produtoProcurado.setId(produto.getId());
        produtoProcurado.setQuantidade(produto.getQuantidade());
        produtoProcurado.setTipo(produto.getTipo());
        produtoProcurado.setValor(produto.getValor());
        produtoProcurado.setDescricao(produto.getDescricao());
    }

    public boolean temProdutos(){
        if(listaDeProdutos.size() > 0){
            return true;
        } else {
            return false;
        }
    }

    public void listarProdutos() {
        for (int i = 0; i < listaDeProdutos.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeProdutos.get(i));
        }
    }

    public List<Produto> selecionarProdutoPorIndice(Integer index){
        this.listaDeProdutos.contains(index.intValue());
        return null;
    }

    public Produto getProduto(int index){
        return listaDeProdutos.get(index);
    }

    public boolean isEmpty(){
        return this.listaDeProdutos.isEmpty();
    }
}
