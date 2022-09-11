package com.lp3.alfa_beto.repositories;

import com.lp3.alfa_beto.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.EstudanteAtividade;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EstudanteAtividadeRepository extends JpaRepository<EstudanteAtividade, Long> {

    //LETRA E)
    @Query("SELECT ea FROM EstudanteAtividade ea " +
            "WHERE ea.dataDeAvaliacao BETWEEN ?1 AND ?2")
    List<EstudanteAtividade> aaaaa(LocalDateTime dataInicial, LocalDateTime dataFinal);
}
