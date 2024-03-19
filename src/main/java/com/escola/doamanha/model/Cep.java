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
@Table(name="Cep")
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String localidade;
    public String uf;

    @OneToOne(mappedBy = "cep")
    @JoinColumn(name = "escola_id")
    @JsonBackReference
    private Escola escola;

    public Cep() {
    }

    public Cep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, Escola escola) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.escola = escola;
    }
}
