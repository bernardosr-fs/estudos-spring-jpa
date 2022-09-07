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
public class Atividade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_atividade")
    private Long id;

    private String descricao;
    private String titulo;
    private double nota;
    private LocalDateTime dataDeAvaliacao;
}
