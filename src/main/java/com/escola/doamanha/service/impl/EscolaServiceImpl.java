package com.escola.doamanha.service.impl;

import com.escola.doamanha.dto.EscolaRequest;
import com.escola.doamanha.dto.ProfessorRequest;
import com.escola.doamanha.dto.UpdateEscolaRequest;
import com.escola.doamanha.model.Cep;
import com.escola.doamanha.model.Escola;
import com.escola.doamanha.model.Professor;
import com.escola.doamanha.repository.CepRepository;
import com.escola.doamanha.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EscolaServiceImpl implements EscolaService {

    private EscolaRepository escolaRepository;
    private CepRepository cepRepository;
    private CepService cepService;

    public EscolaServiceImpl(EscolaRepository escolaRepository, CepRepository cepRepository, CepService cepService) {
        this.escolaRepository = escolaRepository;
        this.cepRepository = cepRepository;
        this.cepService = cepService;
    }

    @Override
    public Escola saveEscola(EscolaRequest request) {

        // Criar uma nova escola com base nos dados da requisição
        Escola escola = new Escola();
        escola.setNome(request.getNome());

        // Verificar se a requisição possui um CEP
        if (request.getCep() != null) {
            // Criar um novo CEP com base nos dados da requisição
            Cep cep = cepService.getCep(request.getCep());

            // Salvar o CEP no banco de dados
            cep = cepRepository.save(cep);

            // Associar o CEP à escola
            escola.setCep(cep);
        }

        // Criar e associar os professores à escola
        List<Professor> professores = new ArrayList<>();
        for (ProfessorRequest professorRequest : request.getProfessores()) {
            Professor professor = new Professor();
            professor.setNome(professorRequest.getNome());
            professor.setMateria(professorRequest.getMateria());
            professor.setEscola(escola);
            professores.add(professor);
        }
        escola.setProfessores(professores);

        // Salvar a escola no banco de dados
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
