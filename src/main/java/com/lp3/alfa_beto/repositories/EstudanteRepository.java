package com.lp3.alfa_beto.repositories;

import java.util.List;
import java.util.Optional;

import com.lp3.alfa_beto.entities.Medalha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Estudante;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    //LETRA D)
    List<Estudante> findByMedalhas_Id(Long id);

    // LETRA H)
    @Query("SELECT e FROM Estudante e " +
            "WHERE e.id IN " +
            "(SELECT ea.estudante.id FROM EstudanteAtividade ea WHERE ea.nota = ?1 AND ea.atividade.id = ?2)")
    List<Estudante> findAllByNotaAndIdAtividade(double nota, Long idAtividade);

    public Optional<Estudante> findById(Long id);

    public List<Estudante> findAll();
}
