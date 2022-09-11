package com.lp3.alfa_beto.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Atividade;
import com.lp3.alfa_beto.entities.Estudante;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    //LETRA A)
    List<Atividade> findAllByTituloOrDescricaoContainingIgnoreCase(String titulo, String descricao);

    //LETRA B)
    @Query("SELECT a FROM Atividade a " +
            "WHERE a.id IN " +
            "(SELECT ea.atividade.id FROM EstudanteAtividade ea WHERE ea.estudante.id = ?1)")
    List<Atividade> findAllByIdEstudante(Long idEstudante);
}
