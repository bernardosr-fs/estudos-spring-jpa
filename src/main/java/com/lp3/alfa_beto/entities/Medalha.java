package com.lp3.alfa_beto.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ManyToMany(mappedBy = "medalhas")
    private List<Estudante> estudantes;
}
