package com.lp3.alfa_beto.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Atividade [descricao=" + descricao + ", id=" + id + ", titulo=" + titulo + "]";
    }
}
