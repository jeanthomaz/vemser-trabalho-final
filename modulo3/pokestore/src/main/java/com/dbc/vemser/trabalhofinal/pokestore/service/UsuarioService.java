package com.dbc.vemser.trabalhofinal.pokestore.service;

import com.dbc.vemser.trabalhofinal.pokestore.exceptions.*;
import com.dbc.vemser.trabalhofinal.pokestore.model.Usuario;
import com.dbc.vemser.trabalhofinal.pokestore.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    // criação de um objeto
    public void adicionarUsuario(Usuario usuario) {
        try {
            if (usuario.getCpf().length() != 11) {
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
            List<Usuario> usuarios = usuarioRepository.listar();
            usuarios.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
           throw new RuntimeException(e.getCause());
        }
    }

        public Usuario verificarUsuario (Usuario usuario) {
        try {
            return usuarioRepository.pegarLogin(usuario);
        } catch (BancoDeDadosException e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
        }
    }
