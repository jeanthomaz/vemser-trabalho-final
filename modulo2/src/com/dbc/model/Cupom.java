package com.dbc.model;

public class Cupom {

    private int idCupom;
    private double valor; //TESTE CRUD VALOR > 0
    private String validade; //TESTE CRUD BOOLEAN VALIDO


    public Cupom(){

    }

    public Cupom(double valor, String validade) {
        this.valor = valor;
        this.validade = validade;
    }

    public void imprimirCupom(){
        System.out.println("com.dbc.model.Cupom de desconto de " + valor * 100 + "%");
        System.out.println("Ainda é autenticável: " + validade);
    }

    @Override
    public String toString() {
        return "com.dbc.model.Cupom{" +
                "valor=" + valor +
                ", validade=" + validade +
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

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
