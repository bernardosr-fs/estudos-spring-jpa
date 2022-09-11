package com.lp3.alfa_beto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.EstudanteAtividade;
import com.lp3.alfa_beto.repositories.EstudanteAtividadeRepository;

@Service
public class EstudanteAtividadeService {

    @Autowired
    private EstudanteAtividadeRepository estudanteAtividadeRepository;

    public List<EstudanteAtividade> findAll() {
        return estudanteAtividadeRepository.findAll();
    }

    public void save(EstudanteAtividade estudanteAtividade) {
        estudanteAtividadeRepository.save(estudanteAtividade);
    }
}
