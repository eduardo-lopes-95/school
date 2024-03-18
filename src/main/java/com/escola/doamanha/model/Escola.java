package com.escola.doamanha.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="Escola")

public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome", nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "escola_id")
    private List<Professor> professores;

    public Escola() {
    }

    public Escola(long id) {
        this.id = id;
    }
}
