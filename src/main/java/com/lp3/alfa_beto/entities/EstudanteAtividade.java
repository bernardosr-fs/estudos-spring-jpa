package com.lp3.alfa_beto.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteAtividade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private double nota;
    private LocalDateTime dataDeAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_estudante")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "id_atividade")
    private Atividade atividade;

    @Override
    public String toString() {
        return "EstudanteAtividade [id=" + id + ", nota=" + nota + ", dataDeAvaliacao=" + dataDeAvaliacao
                + ", estudante="
                + estudante.toString() + ", atividade=" + atividade.toString() + "]";
    }
}
