package com.dbc.vemser.pokestore.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Cupom {


    @NotNull
    @Positive
    private Integer idCupom;

    @NotNull
    @Positive
    private double valor;

    @NotNull
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
