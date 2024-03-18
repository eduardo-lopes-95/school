package com.escola.doamanha.model;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name = "escola_id")
    private Escola escola;
}
