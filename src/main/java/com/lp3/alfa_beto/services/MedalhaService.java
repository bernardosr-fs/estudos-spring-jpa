package com.lp3.alfa_beto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.alfa_beto.entities.Medalha;
import com.lp3.alfa_beto.repositories.MedalhaRepository;

@Service
public class MedalhaService {

    @Autowired
    private MedalhaRepository medalhaRepository;

    public void save(Medalha medalha) {
        medalhaRepository.save(medalha);
    }
}
