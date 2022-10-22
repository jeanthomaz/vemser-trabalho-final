package com.dbc.vemser.pokestore.service;

import com.dbc.vemser.pokestore.dto.UsuarioCreateDTO;
import com.dbc.vemser.pokestore.dto.UsuarioDTO;
import com.dbc.vemser.pokestore.exceptions.*;
import com.dbc.vemser.pokestore.entity.Usuario;
import com.dbc.vemser.pokestore.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final ObjectMapper objectMapper;

    // criação de um objeto
    public UsuarioDTO adicionarUsuario(UsuarioCreateDTO usuario) throws BancoDeDadosException, RegraDeNegocioException {
        Usuario usuarioEntity = objectMapper.convertValue(usuario, Usuario.class);
        if (usuarioEntity.getCpf().length() != 11) {
                throw new RegraDeNegocioException("CPF Inválido!");
        } else if (usuarioEntity.getEmail() != null && usuarioRepository.findByEmail(usuarioEntity)) {
                throw new RegraDeNegocioException("Email já cadastrado!");
        } else if (usuarioEntity.getCpf() != null && usuarioRepository.findByCPF(usuarioEntity)) {
                throw new RegraDeNegocioException("CPF já cadastrado!");
        } else if (usuarioEntity.getPix() != null && usuarioRepository.findByPix(usuarioEntity)) {
                throw new RegraDeNegocioException("PIX já cadastrado!");
        }
        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuarioRepository.adicionar(usuarioEntity), UsuarioDTO.class);
        System.out.println("Usuario adicinado com sucesso! " + usuarioEntity);
        return usuarioDTO;
    }

    // remoção
    public void remover(Integer id) throws BancoDeDadosException {
            boolean conseguiuRemover = usuarioRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
    }

    // atualização de um objeto
    public UsuarioDTO editar(Integer id, UsuarioCreateDTO usuario) throws RegraDeNegocioException, BancoDeDadosException{
        Usuario usuarioRecuperado = findById(id);
        usuarioRepository.editar(id,usuarioRecuperado);
        boolean conseguiuEditar = usuarioRepository.editar(id,usuarioRecuperado);
        System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuarioRecuperado, UsuarioDTO.class);
        return usuarioDTO;
    }

    // leitura
    public List<UsuarioDTO> listar() throws RegraDeNegocioException, BancoDeDadosException {
        return usuarioRepository.listar().stream()
                    .map(usuario -> objectMapper.convertValue(usuario, UsuarioDTO.class))
                    .toList();
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

    public Usuario findById(Integer id) throws RegraDeNegocioException, BancoDeDadosException {
        Usuario usuarioRecuperado = usuarioRepository.listar().stream()
                .filter(usuario -> usuario.getIdUsuario().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Usuario não encontrado"));
        return usuarioRecuperado;
    }

    }
