package com.lp3.alfa_beto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.Estudante;
import com.lp3.alfa_beto.repositories.EstudanteRepository;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;

    public void save(Estudante e) {
        repository.save(e);
    }

    // public List<Estudante> findAllByMedalhas(List<Medalha> medalhas) {
    // return repository.findAllByMedalhas(medalhas);
    // }

    public Optional<Estudante> findById(Long id) {
        return repository.findById(id);
    }

    public List<Estudante> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Optional<Estudante> findByMatricula(String matricula) {
        return repository.findByMatricula(matricula);
    }

    public List<Estudante> findAll() {
        return repository.findAll();
    }
}
