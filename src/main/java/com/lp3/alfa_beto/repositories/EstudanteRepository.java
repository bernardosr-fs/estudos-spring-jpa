package com.lp3.alfa_beto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
