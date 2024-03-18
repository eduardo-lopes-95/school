package com.escola.doamanha.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name="Professor")

public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="materia", nullable = false)
    private String materia;

    @ManyToOne
    @JoinColumn(name = "escola_id", nullable = false)
    @JsonBackReference
    private Escola escola;

    public Professor() {

    }

    public Professor(String nome, String materia, Escola escola) {
        this.nome = nome;
        this.materia = materia;
        this.escola = escola;
    }
}
