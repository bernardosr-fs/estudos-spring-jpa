package com.lp3.alfa_beto.services;

import java.util.List;
import java.util.Optional;

import com.lp3.alfa_beto.entities.Medalha;
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

    public List<Estudante> findAll() {
        return repository.findAll();
    }

    // LETRA D)
    public List<Estudante> findAllByIdMedalha(Long idMedalha) {
        return repository.findByMedalhas_Id(idMedalha);
    }

    // LETRA F)
    public List<Estudante> findAllOrderByMedalhas(String sentidoOrdenamento) {
        List<Estudante> estudantes = repository.findAll();

        if (sentidoOrdenamento.equalsIgnoreCase("ASC")) {
            estudantes.sort((e1, e2) -> e1.getMedalhas().size() - e2.getMedalhas().size());
        } else {
            estudantes.sort((e1, e2) -> e2.getMedalhas().size() - e1.getMedalhas().size());
        }

        return estudantes;
    }
}
