package com.lp3.alfa_beto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.Atividade;
import com.lp3.alfa_beto.repositories.AtividadeRepository;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public void save(Atividade atividade) {
        atividadeRepository.save(atividade);
    }
}
