package com.escola.doamanha.service.impl;

import com.escola.doamanha.dto.ProfessorRequest;
import com.escola.doamanha.model.Escola;
import com.escola.doamanha.model.Professor;

import java.util.List;

public interface ProfessorService {
    Professor saveProfessor(ProfessorRequest request);
    List<Professor> getAllProfessores(long escolaId);
    Professor getProfessorById(long id);
    Professor updateProfessor(ProfessorRequest request, long id);
    void deleteProfessor(long id);
}
