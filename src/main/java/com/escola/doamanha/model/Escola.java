package com.escola.doamanha.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name="Escola")

public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Professor> professores;

    public Escola() {
    }

    public Escola(String nome, List<Professor> professores) {
        this.nome = nome;
        this.professores = professores;
    }

}
