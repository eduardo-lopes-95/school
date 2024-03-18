package com.escola.doamanha.service.impl;

import com.escola.doamanha.dto.EscolaRequest;
import com.escola.doamanha.dto.ProfessorRequest;
import com.escola.doamanha.dto.UpdateEscolaRequest;
import com.escola.doamanha.model.Escola;

import java.util.List;

public interface EscolaService {
    Escola saveEscola(EscolaRequest Escola);
    List<Escola> getAllEscolas();
    Escola getEscolaById(long id);
    Escola updateEscola(UpdateEscolaRequest Escola, long id);
    void deleteEscola(long id);
}
