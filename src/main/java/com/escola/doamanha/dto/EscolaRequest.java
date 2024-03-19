package com.escola.doamanha.dto;

import com.escola.doamanha.model.Professor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class EscolaRequest {
    private String nome;

    private String cep;

    private List<ProfessorRequest> professores;
}
