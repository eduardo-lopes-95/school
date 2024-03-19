package com.escola.doamanha.service.impl;

import com.escola.doamanha.dto.ProfessorRequest;
import com.escola.doamanha.model.Escola;
import com.escola.doamanha.model.Professor;
import com.escola.doamanha.repository.EscolaRepository;
import com.escola.doamanha.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor saveProfessor(ProfessorRequest request) {
        Professor professor = new Professor();
        professor.setNome(request.getNome());
        professor.setMateria(request.getMateria());
        //professor.setEscola(EscolaService.getEscolaById(request.getEscolaId()));
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessores(long escolaId) {
        List<Professor> professores = new ArrayList<>();

        for (Professor prof : professorRepository.findAll()) {
            if(prof.getEscola().getId() == escolaId){
                professores.add(prof);
            }
        }

        return professores;
    }

    @Override
    public Professor getProfessorById(long id) {
        // Busca o professor pelo ID e retorna um Optional
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        return optionalProfessor.orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }

    @Override
    public Professor updateProfessor(ProfessorRequest request, long id) {
        Professor entity = getProfessorById(id);
        entity.setNome(request.getNome());
        entity.setMateria(request.getMateria());
        return professorRepository.save(entity);
    }

    @Override
    public void deleteProfessor(long id) {
        professorRepository.deleteById(id);
    }
}
