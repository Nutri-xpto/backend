package com.example.demo.controllers;

import java.util.List;

import com.example.demo.repositories.ReceitaRepository;
import com.example.demo.services.LoginService;
import com.example.demo.services.RefeicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.RefeicaoDTO;
import com.example.demo.model.Refeicao;
import com.example.demo.repositories.RefeicaoRepository;

@RestController
public class RefeicaoController {


    private final RefeicaoService service;
    private final RefeicaoRepository refeicaoRepository;
    private final ReceitaRepository receitaRepository;

    RefeicaoController( RefeicaoRepository refeicaoRepository, ReceitaRepository receitaRepository) {
        this.refeicaoRepository = refeicaoRepository ;
        this.receitaRepository = receitaRepository;
        this.service =  new RefeicaoService(refeicaoRepository, receitaRepository);
    }

    @GetMapping("/refeicoes")
    ResponseEntity<List<Refeicao>> getAll() {
        return new ResponseEntity<List<Refeicao>>(this.refeicaoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/refeicao/{id}")
    ResponseEntity<Refeicao> getRefeicao(@PathVariable int id) {
        return new ResponseEntity<Refeicao>(this.refeicaoRepository.findById(Long.valueOf(id)).get(), HttpStatus.OK);
    }

    @PostMapping("/refeicao")
    ResponseEntity<Refeicao> createRefeicao(@RequestBody RefeicaoDTO refeicao) {
        return new ResponseEntity<Refeicao>(this.service.save(Refeicao.dtoToEntity(refeicao)), HttpStatus.CREATED);
    }
}
