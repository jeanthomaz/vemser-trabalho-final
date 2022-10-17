package com.dbc.model;

public class Cupom {

    private Integer idCupom;
    private double valor;

    private String deletado;


    public Cupom(){
        this.setDeletado("F");
    }

    public Cupom(Integer idCupom, double valor) {
        this.idCupom = idCupom;
        this.valor = valor;
        this.setDeletado("F");
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "idCupom=" + idCupom +
                ", valor=" + valor +
                ", deletado='" + deletado + '\'' +
                '}';
    }

    public Integer getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(Integer idCupom) {
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
