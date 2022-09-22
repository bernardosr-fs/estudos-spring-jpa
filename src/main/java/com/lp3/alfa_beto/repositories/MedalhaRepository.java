package com.lp3.alfa_beto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Estudante;
import com.lp3.alfa_beto.entities.Medalha;

@Repository
public interface MedalhaRepository extends JpaRepository<Medalha, Long> {

    // LETRA C)
    List<Medalha> findByEstudantes_Id(Long id);
}
