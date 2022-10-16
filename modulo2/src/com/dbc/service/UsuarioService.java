package com.dbc.service;

import com.dbc.exceptions.*;
import com.dbc.model.Usuario;
import com.dbc.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    // criação de um objeto
    public void adicionarUsuario(Usuario usuario) {
        try {
            if (usuario.getCidade().length() != 11) {
                throw new Exception("CPF Inválido!");
            } else if (usuario.getEmail() != null && usuarioRepository.findByEmail(usuario)) {
                throw new Exception("Email já cadastrado!");
            } else if (usuario.getCpf() != null && usuarioRepository.findByCPF(usuario)) {
                throw new Exception("CPF já cadastrado!");
            } else if (usuario.getPix() != null && usuarioRepository.findByPix(usuario)) {
                throw new Exception("PIX já cadastrado!");
            }
            Usuario usuarioAdicionado = usuarioRepository.adicionar(usuario);
            System.out.println("Usuario adicinado com sucesso! " + usuarioAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    // remoção
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = usuarioRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editar(Integer id, Usuario usuario) {
        try {
            boolean conseguiuEditar = usuarioRepository.editar(id, usuario);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listar() {
        try {
            usuarioRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public Usuario fazerLogin (String email, String senha) throws EmailRepetidoException, BancoDeDadosException {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        if (usuarioRepository.findByEmail(usuario)) {
            if (usuarioRepository.findBySenha(usuario)) {
                return usuario;
            } else {
                throw new EmailRepetidoException("Senha não existente, digitar novamente");
            }
        }
        else {
            throw new EmailRepetidoException("E-mail não existente, digitar novamente");
        }
    }
}