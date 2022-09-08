package com.lp3.alfa_beto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.Estudante;
import com.lp3.alfa_beto.entities.Medalha;
import com.lp3.alfa_beto.repositories.EstudanteRepository;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;

    public void save(Estudante e) {
        repository.save(e);
    }

    public List<Estudante> findAllByMedalhas(List<Medalha> medalhas) {
        return repository.findAllByMedalhas(medalhas);
    }
}
