package com.dbc.vemser.pokestore.model;

import com.dbc.vemser.pokestore.enums.Tipos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Produto {

    @NotBlank
    @Positive
    private Integer idProduto;

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotBlank
    @Size(max = 250)
    private String descricao;

    @NotBlank
    @Positive
    private int quantidade;

    @NotBlank
    @Positive
    private Tipos tipo;

    @NotBlank
    @Positive
    private double valor;

    @NotBlank
    @Positive
    private int idUsuario;

    @NotBlank
    private String deletado;

    Usuario usuario;

    public Produto(){
        this.setDeletado("F");
    }

    public Produto(Integer idProduto, String nome, String descricao, int quantidade, Tipos tipo, double valor, int idUsuario, String deletado) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.valor = valor;
        this.idUsuario = idUsuario;
        this.setDeletado("F");
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
