package com.lp3.alfa_beto.entities;

import java.util.List;

import javax.persistence.*;

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
    @JoinTable(name = "estudante_medalha", joinColumns = @JoinColumn(name = "id_estudante"), inverseJoinColumns = @JoinColumn(name = "id_medalha"))
    private List<Medalha> medalhas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudante")
    private List<EstudanteAtividade> atividades;

    @ManyToMany(mappedBy = "estudantes")
    private List<Responsavel> responsaveis;
}
