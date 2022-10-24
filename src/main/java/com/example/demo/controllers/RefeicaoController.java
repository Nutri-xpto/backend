package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<List<Refeicao>> getAll() {
        return new ResponseEntity<List<Refeicao>>(this.repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/refeicao/{id}")
    ResponseEntity<Refeicao> getRefeicao(@PathVariable int id) {
        return new ResponseEntity<Refeicao>(this.repository.findById(Long.valueOf(id)).get(), HttpStatus.OK);
    }

    @PostMapping("/refeicao")
    ResponseEntity<Refeicao> createRefeicao(@RequestBody RefeicaoDTO refeicao) {
        return new ResponseEntity<Refeicao>(this.repository.save(Refeicao.dtoToEntity(refeicao)), HttpStatus.CREATED);
    }
}
