package com.escola.doamanha.dto;

import com.escola.doamanha.model.Professor;

import java.util.List;

public class EscolaRequest {
    private String nome;

    public List<ProfessorRequest> getProfessores() {
        return professores;
    }

    public void setProfessores(List<ProfessorRequest> professores) {
        this.professores = professores;
    }

    private List<ProfessorRequest> professores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
