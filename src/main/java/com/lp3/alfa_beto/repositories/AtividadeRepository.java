package com.lp3.alfa_beto.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    public List<Atividade> findAllByTituloContainingIgnoreCase(String titulo);

    public List<Atividade> findAllByDescricaoContainingIgnoreCase(String descricao);

    public List<Atividade> findAllById(Long id);

    public List<Atividade> findByDataDeAvaliacaoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
}
