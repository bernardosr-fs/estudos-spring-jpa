package com.lp3.alfa_beto.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Atividade;
import com.lp3.alfa_beto.entities.EstudanteAtividade;

@Repository
public interface EstudanteAtividadeRepository extends JpaRepository<EstudanteAtividade, Long> {

    // LETRA E)
    @Query("SELECT ea FROM EstudanteAtividade ea " +
            "WHERE ea.dataDeAvaliacao BETWEEN ?1 AND ?2")
    List<EstudanteAtividade> findAllBetweenDataInicialAndDataFinal(LocalDateTime dataInicial, LocalDateTime dataFinal);

    Optional<EstudanteAtividade> findByAtividade(Atividade atividade);

    // LETRA H)
    List<EstudanteAtividade> findAllByNotaBetween(double from, double to);
}
