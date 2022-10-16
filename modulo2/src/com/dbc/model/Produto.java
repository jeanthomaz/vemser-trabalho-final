package com.dbc.model;

import com.dbc.enums.Tipos;

public class Produto {

    private Integer idProduto;
    private String nome;
    private String descricao;
    private int quantidade;
    private Tipos tipo;
    private double valor;
    private int idUsuario;

    private String deletado;

    Usuario usuario;

    public Produto(){

    }

    public Produto(Integer idProduto, String nome, String descricao, int quantidade, Tipos tipo, double valor, int idUsuario, String deletado) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.valor = valor;
        this.idUsuario = idUsuario;
        this.deletado = deletado;
    }

    @Override
    public String toString() {
        return "ProdutoService{" +
                "idProduto=" + idProduto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", tipo=" + tipo +
                ", valor=" + valor +
                ", idUsuario=" + idUsuario +
                ", deletado=" + deletado +
                '}';
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
