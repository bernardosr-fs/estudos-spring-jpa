package com.lp3.alfa_beto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.Estudante;
import com.lp3.alfa_beto.entities.Medalha;
import com.lp3.alfa_beto.repositories.MedalhaRepository;

@Service
public class MedalhaService {

    @Autowired
    private MedalhaRepository medalhaRepository;

    public void save(Medalha medalha) {
        medalhaRepository.save(medalha);
    }

    // public List<Medalha> findAllByEstudantes(List<Estudante> estudantes) {
    // return medalhaRepository.findAllByEstudantes(estudantes);
    // }

    public List<Medalha> findAll() {
        return medalhaRepository.findAll();
    }
}
