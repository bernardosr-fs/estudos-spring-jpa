package com.lp3.alfa_beto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.EstudanteAtividade;

@Repository
public interface EstudanteAtividadeRepository extends JpaRepository<EstudanteAtividade, Long> {

}
