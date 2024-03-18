package com.escola.doamanha.service.impl;

import com.escola.doamanha.model.Professor;
import com.escola.doamanha.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(long id) {
        return professorRepository.getReferenceById(id);
    }

    @Override
    public Professor updateProfessor(Professor professor, long id) {
        Professor entity = getProfessorById(id);
        entity.setNome(professor.getNome());
        entity.setMateria(professor.getMateria());
        entity.setEscola(professor.getEscola());
        professorRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteProfessor(long id) {
        professorRepository.deleteById(id);
    }
}
