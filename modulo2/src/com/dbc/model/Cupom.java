package com.dbc.model;

public class Cupom {

    private int idCupom;
    private double valor;

    private String deletado;


    public Cupom(){

    }

    public Cupom(int idCupom, double valor) {
        this.idCupom = idCupom;
        this.valor = valor;
        this.setDeletado("F");
    }

    public void imprimirCupom(){
        System.out.println("com.dbc.model.Cupom de desconto de " + valor * 100 + "%");
        System.out.println("Ainda é autenticável: " + deletado);
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "idCupom=" + idCupom +
                ", valor=" + valor +
                ", deletado='" + deletado + '\'' +
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
