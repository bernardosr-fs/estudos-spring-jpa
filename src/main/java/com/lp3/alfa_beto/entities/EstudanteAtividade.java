package com.lp3.alfa_beto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class EstudanteAtividade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private double nota;
    private LocalDateTime dataDeAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_estudante")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "id_atividade")
    private Atividade atividade;
}
