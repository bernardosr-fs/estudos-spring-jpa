package com.lp3.alfa_beto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsavel")
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String senha;

    @ManyToMany
    @JoinTable(name = "responsavel_estudante", joinColumns = @JoinColumn(name = "id_responsavel"), inverseJoinColumns = @JoinColumn(name = "id_estudante"))
    private List<Estudante> estudantes = new ArrayList<Estudante>();

    public void addEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
    }
}
