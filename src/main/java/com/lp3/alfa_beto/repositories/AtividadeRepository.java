package com.lp3.alfa_beto.repositories;

import java.util.List;

import com.lp3.alfa_beto.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    public List<Atividade> findAllByTituloOrDescricaoContainingIgnoreCase(String pesquisa);

    public List<Atividade> findAllByIdEstudante(Long idEstudante);
}
