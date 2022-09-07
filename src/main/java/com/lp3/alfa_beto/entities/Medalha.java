package com.lp3.alfa_beto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Medalha {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_medalha")
    private Long id;

    private String titulo;
}
