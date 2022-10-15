package com.dbc.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

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

    public double getValor() {
        if (produtos.size() > 0) {
            double a = 1;
            double b = 0;
            double aux;
            for (int i = 0; i < produtos.size(); i++) {
                aux = produtos.get(i).getValor() * produtos.get(i).getQuantidade();
                a = aux + b;
                b = a;
            }
            if (cupom == null) {
                return b;
            } else {
                double valor = b - cupom.getValor();
                return valor;
            }
        } else {
           return 0;
        }
    }

    public void removerProdutos() {

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

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", produtos=" + produtos +
                ", cupons=" + cupons +
                ", cupom=" + cupom +
                '}';
    }
}
