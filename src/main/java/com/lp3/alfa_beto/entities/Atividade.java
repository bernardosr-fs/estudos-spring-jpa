package com.lp3.alfa_beto.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EstudanteAtividade> estudantes;

    @Override
    public String toString() {
        return "Atividade [descricao=" + descricao + ", id=" + id + ", titulo=" + titulo + "]";
    }
}
