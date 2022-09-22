package com.lp3.alfa_beto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.Atividade;
import com.lp3.alfa_beto.entities.Estudante;
import com.lp3.alfa_beto.repositories.AtividadeRepository;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public void save(Atividade atividade) {
        atividadeRepository.save(atividade);
    }

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    // LETRA A)
    public List<Atividade> findAllByTituloOrDescricao(String titulo, String descricao) {
        return atividadeRepository.findAllByTituloOrDescricaoContainingIgnoreCase(titulo, descricao);
    }

    // LETRA B)
    public List<Atividade> findAllByIdEstudante(Long idEstudante) {
        return atividadeRepository.findAllByIdEstudante(idEstudante);
    }
}
