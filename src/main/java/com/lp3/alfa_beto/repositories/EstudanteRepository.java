package com.lp3.alfa_beto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lp3.alfa_beto.entities.Estudante;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    //Consulta Letra h)
    //@Query(value = "SELECT * FROM estudante e "+
            //"WHERE e.id_estudante IN (SELECT ea.id_estudante FROM estudante_atividade ea WHERE gu.usuario.id = ?2)",
           // nativeQuery = true)
    //List<Estudante> listarEstudantesPorNotaNaAtividade(double nota, Long idAtividade);
}
