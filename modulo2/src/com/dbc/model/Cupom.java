package com.dbc.model;

public class Cupom {

    private int idCupom;
    private double valor;

    private String deletado;


    public Cupom(){

    }

    public Cupom(double valor, String validade) {
        this.valor = valor;
        this.deletado = validade;
    }

    public void imprimirCupom(){
        System.out.println("com.dbc.model.Cupom de desconto de " + valor * 100 + "%");
        System.out.println("Ainda é autenticável: " + deletado);
    }

    @Override
    public String toString() {
        return "com.dbc.model.Cupom{" +
                "valor=" + valor +
                ", validade=" + deletado +
                '}';
    }

    public int getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String validade) {
        this.deletado = validade;
    }
}
