package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RefeicaoDTO;
import com.example.demo.model.Refeicao;
import com.example.demo.repositories.RefeicaoRepository;

@RestController
public class RefeicaoController {

    private final RefeicaoRepository repository;

    RefeicaoController(RefeicaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/refeicoes")
    ResponseEntity<List<Refeicao>> getAll(){
        return new ResponseEntity<List<Refeicao>>( this.repository.findAll(), HttpStatus.OK );
    }
    
    @PostMapping("/refeicao")
    Refeicao createRefeicao(@RequestBody RefeicaoDTO refeicao){
        return this.repository.save( Refeicao.dtoToEntity(refeicao) ) ;
    }
}
