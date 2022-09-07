package com.lp3.alfa_beto.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
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
    private List<Estudante> estudantes;
}
