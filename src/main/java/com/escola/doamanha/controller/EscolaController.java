package com.escola.doamanha.controller;

import com.escola.doamanha.model.Escola;
import com.escola.doamanha.service.impl.EscolaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escola")
public class EscolaController {

    private EscolaService escolaService;

    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    // build create Escola REST API
    @PostMapping("create")
    public ResponseEntity<Escola> saveEscola(@RequestBody Escola Escola){
        return new ResponseEntity<Escola>(escolaService.saveEscola(Escola), HttpStatus.CREATED);
    }

    // build get all Escolas REST API
    @GetMapping
    public List<Escola> getAllEscolas(){
        return escolaService.getAllEscolas();
    }

    // build get Escola by id REST API
    // http://localhost:8080/api/Escolas/1
    @GetMapping("{id}")
    public ResponseEntity<Escola> getEscolaById(@PathVariable("id") long EscolaId){
        return new ResponseEntity<Escola>(escolaService.getEscolaById(EscolaId), HttpStatus.OK);
    }

    // build update Escola REST API
    // http://localhost:8080/api/Escolas/1
    @PutMapping("{id}")
    public ResponseEntity<Escola> updateEscola(@PathVariable("id") long id
            ,@RequestBody Escola Escola){
        return new ResponseEntity<Escola>(escolaService.updateEscola(Escola, id), HttpStatus.OK);
    }

    // build delete Escola REST API
    // http://localhost:8080/api/Escolas/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEscola(@PathVariable("id") long id){

        // delete Escola from DB
        escolaService.deleteEscola(id);

        return new ResponseEntity<String>("Escola deleted successfully!.", HttpStatus.OK);
    }
}
