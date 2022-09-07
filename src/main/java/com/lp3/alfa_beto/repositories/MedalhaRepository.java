package com.lp3.alfa_beto.repositories;

import java.util.List;

import com.lp3.alfa_beto.entities.Medalha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalhaRepository extends JpaRepository<Medalha, Long> {

    public List<Medalha> findAllByIdEstudante(Long idEstudante);
}
