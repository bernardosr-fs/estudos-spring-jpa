package com.lp3.alfa_beto.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medalha {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_medalha")
    private Long id;

    private String titulo;

    @ManyToMany(mappedBy = "medalhas", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Estudante> estudantes = new ArrayList<Estudante>();

    public void addEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
    }
}
