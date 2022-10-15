package com.dbc.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Produto> produtos;
    private Cupom cupom;

    private int idPedido;
    private int idCupom;
    private int idUsuario;
    private double valorFinal;

    public Pedido() {

    }

    public Pedido(int idPedido, int idCupom, int idUsuario, double valorFinal) {
        this.idPedido = idPedido;
        this.idCupom = idCupom;
        this.idUsuario = idUsuario;
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produtos=" + produtos +
                ", cupom=" + cupom +
                ", idPedido=" + idPedido +
                ", idCupom=" + idCupom +
                ", idUsuario=" + idUsuario +
                ", valorFinal=" + valorFinal +
                '}';
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorFinal(Produto produto, Cupom cupom) {
        if (produtos.size() > 0) {
            double aux = 0;
            for (Produto value : produtos) {
                aux += value.getValor() * value.getQuantidade();
                if (cupom.getValidade() == "1") {
                    double valorFinal = aux - cupom.getValor();
                } else if (cupom.getValidade() == "0") {
                    double valorFinal = aux;
                } else {
                    double valorFinal = 0;
                }
            }
        }
        return 0;
    }
}
