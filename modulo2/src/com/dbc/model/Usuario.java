package com.dbc.model;

public class Usuario implements Comprar, Vender {

    private String email;
    private String senha;

    private String pix;

    private String nome;
    private String endereco;
    private String cpf;
    private String cidade;
    private String estado;
    private String telefone;

    Usuario usuario;

    public Usuario(){

    }

    public Usuario(String email, String senha, String pix, String nome, String endereco, String cpf, String cidade, String estado, String telefone, Usuario usuario) {
        this.email = email;
        this.senha = senha;
        this.pix = pix;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", pix='" + pix + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cliente=" + usuario +
                '}';
    }

    @Override
    public void comprar() {
        System.out.println("Compra realizada com sucesso.");
    }

    @Override
    public void vender() {
        System.out.println("Venda feita com sucesso! ");
    }

    public String getEmail() {

        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void formaPag(Usuario usuario, String pix) {
        usuario.getPix();
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
}


