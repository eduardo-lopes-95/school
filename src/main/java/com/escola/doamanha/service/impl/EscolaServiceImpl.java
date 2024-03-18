package com.escola.doamanha.service.impl;

import com.escola.doamanha.model.Escola;
import com.escola.doamanha.model.Professor;
import com.escola.doamanha.repository.EscolaRepository;
import com.escola.doamanha.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaServiceImpl implements EscolaService {

    private EscolaRepository escolaRepository;
    private ProfessorService professorService;

    public EscolaServiceImpl(EscolaRepository escolaRepository, ProfessorService professorService) {
        this.escolaRepository = escolaRepository;
        this.professorService = professorService;
    }

    @Override
    public Escola saveEscola(Escola escola) {
        escola.setProfessores(escola.getProfessores());
        for (Professor professor :  escola.getProfessores()) {
            professor.setEscola(escola);
            professorService.saveProfessor(professor);
        }
        return escolaRepository.save(escola);
    }

    @Override
    public List<Escola> getAllEscolas() {
        return escolaRepository.findAll();
    }

    @Override
    public Escola getEscolaById(long id) {
        return escolaRepository.getById(id);
    }

    @Override
    public Escola updateEscola(Escola escola, long id) {
        Escola entity = getEscolaById(id);
        entity.setNome(escola.getNome());
        entity.setProfessores(escola.getProfessores());
        escolaRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteEscola(long id) {
        escolaRepository.deleteById(id);
    }
}
