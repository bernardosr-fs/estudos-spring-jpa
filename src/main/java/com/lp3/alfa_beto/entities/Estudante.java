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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudante")
    private Long id;

    private String nome;
    private String email;
    private String matricula;
    private String senha;

    @ManyToMany
    @JoinTable(name = "Estudante_Medalha", joinColumns = @JoinColumn(name = "id_estudante"), inverseJoinColumns = @JoinColumn(name = "id_medalha"))
    private List<Medalha> medalhas;

    @ManyToMany
    @JoinTable(name = "Estudante_Atividade", joinColumns = @JoinColumn(name = "id_estudante"), inverseJoinColumns = @JoinColumn(name = "id_atividade"))
    private List<Atividade> atividades;

    @ManyToMany(mappedBy = "estudantes")
    private List<Responsavel> responsaveis;
}
