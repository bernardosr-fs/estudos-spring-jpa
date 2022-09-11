package com.lp3.alfa_beto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Medalha> medalhas = new ArrayList<Medalha>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudante")
    private List<EstudanteAtividade> atividades;

    @ManyToMany(mappedBy = "estudantes")
    private List<Responsavel> responsaveis = new ArrayList<Responsavel>();

    public void addMedalha(Medalha medalha) {
        this.medalhas.add(medalha);
    }

    @Override
    public String toString() {
        return "Estudante [email=" + email + ", id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", senha="
                + senha + "]";
    }
}
