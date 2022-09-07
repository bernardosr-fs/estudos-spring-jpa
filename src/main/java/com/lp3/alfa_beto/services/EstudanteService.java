package com.lp3.alfa_beto.services;

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

    public Optional<Estudante> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Iterable<Estudante> findAll() {
        return repository.findAll();
    }
}
