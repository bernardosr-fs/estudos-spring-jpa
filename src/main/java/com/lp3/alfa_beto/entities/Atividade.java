package com.lp3.alfa_beto.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade")
    private List<EstudanteAtividade> estudantes;
}
