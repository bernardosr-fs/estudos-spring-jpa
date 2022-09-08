package com.lp3.alfa_beto.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudante")
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column(unique = true)
    private String matricula;

    @Column
    private String senha;

    @ManyToMany
    @JoinTable(name = "estudante_medalha", joinColumns = @JoinColumn(name = "id_estudante"), inverseJoinColumns = @JoinColumn(name = "id_medalha"))
    private List<Medalha> medalhas;

    @ManyToMany
    @JoinTable(name = "estudante_atividade", joinColumns = @JoinColumn(name = "id_estudante"), inverseJoinColumns = @JoinColumn(name = "id_atividade"))
    private List<Atividade> atividades;

    @ManyToMany(mappedBy = "estudantes")
    private List<Responsavel> responsaveis;
}
