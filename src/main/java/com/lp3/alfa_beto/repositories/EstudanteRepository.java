package com.lp3.alfa_beto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    // public List<Estudante> findAllMedalhasIn(List<Medalha> medalhas);

    public Optional<Estudante> findById(Long id);

    public List<Estudante> findByNome(String nome);

    // find estudante by metricula
    public Optional<Estudante> findByMatricula(String matricula);
}
