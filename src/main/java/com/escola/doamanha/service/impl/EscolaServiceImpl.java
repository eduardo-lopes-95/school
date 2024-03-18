package com.escola.doamanha.service.impl;


import com.escola.doamanha.dto.EscolaRequest;
import com.escola.doamanha.dto.ProfessorRequest;
import com.escola.doamanha.dto.UpdateEscolaRequest;
import com.escola.doamanha.model.Escola;
import com.escola.doamanha.model.Professor;
import com.escola.doamanha.repository.EscolaRepository;
import com.escola.doamanha.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EscolaServiceImpl implements EscolaService {

    private EscolaRepository escolaRepository;
    private ProfessorRepository professorRepository;

    public EscolaServiceImpl(EscolaRepository escolaRepository, ProfessorRepository professorRepository) {
        this.escolaRepository = escolaRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public Escola saveEscola(EscolaRequest request) {

        Escola escola = new Escola();
        escola.setNome(request.getNome());

        List<Professor> professores = new ArrayList<>();
        for (ProfessorRequest professorRequest : request.getProfessores()) {
            Professor professor = new Professor();
            professor.setNome(professorRequest.getNome());
            professor.setMateria(professorRequest.getMateria());
            professor.setEscola(escola);
            professores.add(professor);
        }
        escola.setProfessores(professores);

        return escolaRepository.save(escola);
    }

    @Override
    public List<Escola> getAllEscolas() {
        return escolaRepository.findAll();
    }

    @Override
    public Escola getEscolaById(long id) {
        Optional<Escola> optionalEscola = escolaRepository.findById(id);
        return optionalEscola.orElseThrow(() -> new RuntimeException("Escola não encontrada com o ID: " + id));
    }

    @Override
    public Escola updateEscola(UpdateEscolaRequest request, long id) {

        Escola escola = escolaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escola não encontrada com o ID: " + id));

        escola.setNome(request.getNome());

        escolaRepository.save(escola);
        return escola;
    }

    @Override
    public void deleteEscola(long id) {
        escolaRepository.deleteById(id);
    }
}
