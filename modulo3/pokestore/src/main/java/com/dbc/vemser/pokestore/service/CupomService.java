package com.dbc.vemser.pokestore.service;

import com.dbc.vemser.pokestore.exceptions.BancoDeDadosException;
import com.dbc.vemser.pokestore.entity.Cupom;
import com.dbc.vemser.pokestore.repository.CupomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CupomService {
    private final CupomRepository cupomRepository;


    // criação de um objeto
    public void adicionarCupom(Cupom cupom){
        try{
            Cupom cupomAdicionado = cupomRepository.adicionar(cupom);
            System.out.println("Cupom adicionado com sucesso! " + cupomAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
//            System.out.println("TRACE: ");
//            e.printStackTrace();
        }
    }

    // remoção
    public void removerCupom(Integer id) {
        try {
            boolean conseguiuRemover = cupomRepository.remover(id);
            System.out.println("Cupom removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarCupom(Integer id, Cupom cupom) {
        try {
            boolean conseguiuEditar = cupomRepository.editar(id, cupom);
            System.out.println("Cupom editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public List<Cupom> listarCupons() {
        try {
            List<Cupom> listar = cupomRepository.listar();
            return listar;
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
