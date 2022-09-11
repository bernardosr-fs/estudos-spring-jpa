package com.lp3.alfa_beto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.Responsavel;
import com.lp3.alfa_beto.repositories.ResponsavelRepository;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public void save(Responsavel responsavel) {
        responsavelRepository.save(responsavel);
    }

    // FIND all
    public List<Responsavel> findAll() {
        return responsavelRepository.findAll();
    }
}
