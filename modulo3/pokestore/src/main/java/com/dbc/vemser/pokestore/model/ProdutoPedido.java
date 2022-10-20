package com.dbc.vemser.pokestore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ProdutoPedido {

    @NotBlank
    @Positive
    private Integer idProdutoPedido;

    @NotBlank
    @Positive
    private Produto produto;

    @NotBlank
    @Positive
    private Pedido pedido;

    @NotBlank
    @Positive
    private Integer quantidade;

    @NotBlank
    @Positive
    private Double valor;

    @NotBlank
    @Positive
    private String deletado;

    public ProdutoPedido(){
        this.setDeletado("F");
    }

    public ProdutoPedido(Integer idProdutoPedido, Produto produto, Pedido pedido, Integer quantidade, Double valor) {
        this.idProdutoPedido = idProdutoPedido;
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.valor = valor;
        this.setDeletado("F");
    }

    @Override
    public String toString() {
        return "ProdutoPedido{" +
                "idProdutoPedido=" + idProdutoPedido +
                ", produto=" + produto.getIdProduto() +
                ", pedido=" + (pedido == null ? "" : pedido.getIdPedido()) +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public Integer getIdProdutoPedido() {
        return idProdutoPedido;
    }

    public void setIdProdutoPedido(Integer idProdutoPedido) {
        this.idProdutoPedido = idProdutoPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
