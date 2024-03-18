package com.escola.doamanha.service.impl;

import com.escola.doamanha.model.Escola;
import com.escola.doamanha.model.Professor;

import java.util.List;

public interface ProfessorService {
    Professor saveProfessor(Professor professor);
    List<Professor> getAllProfessores();
    Professor getProfessorById(long id);
    Professor updateProfessor(Professor professor, long id);
    void deleteProfessor(long id);
}
