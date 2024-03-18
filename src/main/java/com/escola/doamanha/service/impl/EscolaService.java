package com.escola.doamanha.service.impl;

import com.escola.doamanha.model.Escola;

import java.util.List;

public interface EscolaService {
    Escola saveEscola(Escola Escola);
    List<Escola> getAllEscolas();
    Escola getEscolaById(long id);
    Escola updateEscola(Escola Escola, long id);
    void deleteEscola(long id);
}
