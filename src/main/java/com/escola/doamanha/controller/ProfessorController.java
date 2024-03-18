package com.escola.doamanha.controller;

import com.escola.doamanha.model.Professor;
import com.escola.doamanha.service.impl.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    // build create Professor REST API
    @PostMapping("create")
    public ResponseEntity<Professor> saveProfessor(@RequestBody Professor professor){
        return new ResponseEntity<Professor>(professorService.saveProfessor(professor), HttpStatus.CREATED);
    }

    // build get all Professors REST API
    @GetMapping
    public List<Professor> getAllProfessores(){
        return professorService.getAllProfessores();
    }

    // build get Professor by id REST API
    // http://localhost:8080/api/Professors/1
    @GetMapping("{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable("id") long professorId){
        return new ResponseEntity<Professor>(professorService.getProfessorById(professorId), HttpStatus.OK);
    }

    // build update Professor REST API
    // http://localhost:8080/api/Professors/1
    @PutMapping("{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable("id") long id
            ,@RequestBody Professor Professor){
        return new ResponseEntity<Professor>(professorService.updateProfessor(Professor, id), HttpStatus.OK);
    }

    // build delete Professor REST API
    // http://localhost:8080/api/Professors/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable("id") long id){

        // delete Professor from DB
        professorService.deleteProfessor(id);

        return new ResponseEntity<String>("Professor deleted successfully!.", HttpStatus.OK);
    }
}
