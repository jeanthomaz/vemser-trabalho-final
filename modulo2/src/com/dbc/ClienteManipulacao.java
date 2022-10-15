package com.dbc;

import com.dbc.exceptions.EmailRepetidoException;
import com.dbc.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteManipulacao {

    private List<Usuario> listaDeUsuarios;

    public ClienteManipulacao() {

        this.listaDeUsuarios = new ArrayList<>();
    }

    public void adicionarCliente(Usuario usuario) {

        this.listaDeUsuarios.add(usuario);
    }

    public void removerClientePorIndice(Integer index) {

        this.listaDeUsuarios.remove(index.intValue());

    }

    public void editarCliente(Integer index, Usuario usuario) {
        Usuario usuarioProcurado = listaDeUsuarios.get(index);
        usuarioProcurado.setNome(usuario.getNome());
        usuarioProcurado.setEndereco(usuario.getEndereco());
        usuarioProcurado.setCpf(usuario.getCpf());
        usuarioProcurado.setCidade(usuario.getCidade());
        usuarioProcurado.setEstado(usuario.getEstado());
        usuarioProcurado.setTelefone(usuario.getTelefone());
        usuarioProcurado.setEmail(usuario.getEmail());
        usuarioProcurado.setSenha(usuario.getSenha());
    }

    public boolean testarEmail(String email) throws EmailRepetidoException {
        Optional<Usuario> testEmail = listaDeUsuarios.stream()
                .filter(usuario -> usuario.getEmail().contains(email))
                .findFirst();
        if (testEmail.isEmpty()) {
            return true;
        } else {
            throw new EmailRepetidoException("E-mail existente, digitar novamente");
        }
    }

    public Usuario fazerLogin(String email, String senha) throws EmailRepetidoException {
        Optional<Usuario> acessarEmail = listaDeUsuarios.stream()
                .filter(usuario -> usuario.getEmail().contains(email))
                .findFirst();
        if (acessarEmail.isPresent()) {
            Optional<Usuario> senhaIgual = acessarEmail.stream()
                    .filter(usuario -> usuario.getSenha().contains(senha))
                    .findFirst();
            if (senhaIgual.isPresent()) {
                return senhaIgual.get();
            } else {
                throw new EmailRepetidoException("Senha não existente, digitar novamente");
            }
        } else {
            throw new EmailRepetidoException("E-mail não existente, digitar novamente");
        }
    }

    public void listarClientes() {
        for (int i = 0; i < listaDeUsuarios.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeUsuarios.get(i));
        }
    }

    public boolean isEmpty() {
        return this.listaDeUsuarios.isEmpty();
    }

}
