package com.dbc.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ProdutoPedido> produtosPedido = new ArrayList<>(); // ID

    private Cupom cupom; // ID

    private int idPedido;
    private int idCupom;
    private int idUsuario;
    private double valorFinal;

    private String deletado;

    public Pedido() {

    }

    public Pedido(List<ProdutoPedido> produtosPedido, Cupom cupom, int idPedido, int idCupom, int idUsuario, double valorFinal, String deletado) {
        this.produtosPedido = produtosPedido;
        this.cupom = cupom;
        this.idPedido = idPedido;
        this.idCupom = idCupom;
        this.idUsuario = idUsuario;
        this.valorFinal = valorFinal;
        this.setDeletado("F");
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produtos=" + produtosPedido +
                ", cupom=" + cupom +
                ", idPedido=" + idPedido +
                ", idCupom=" + idCupom +
                ", idUsuario=" + idUsuario +
                ", valorFinal=" + valorFinal +
                ", deletado='" + deletado + '\'' +
                '}';
    }

    public List<ProdutoPedido> getProdutosPedido() {
        return produtosPedido;
    }

    public void setProdutosPedido(List<ProdutoPedido> produtosPedido) {
        this.produtosPedido = produtosPedido;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorFinal() { // mudar para service
        if (produtosPedido.size() > 0) {
            double valorFinal = 0;
            for (ProdutoPedido value : produtosPedido) {
                valorFinal += value.getValor();
            }
            if (cupom.getDeletado().equals("F")) {
                valorFinal = valorFinal - cupom.getValor();
            }
            return valorFinal;
        }
        return 0;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
}
