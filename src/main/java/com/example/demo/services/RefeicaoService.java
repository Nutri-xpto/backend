package com.example.demo.services;

import com.example.demo.model.Receita;
import com.example.demo.model.Refeicao;
import com.example.demo.repositories.ReceitaRepository;
import com.example.demo.repositories.RefeicaoRepository;

import java.util.List;

public class RefeicaoService {

    private final RefeicaoRepository refeicaorepository;
    private final ReceitaRepository receitaRepository;

    public RefeicaoService(RefeicaoRepository refeicaorepository, ReceitaRepository receitaRepository ) {
        this.refeicaorepository = refeicaorepository;
        this.receitaRepository = receitaRepository;
    }

    public Refeicao save(Refeicao refeicao){
        // Garante que a foreing Key nao vai aṕontar pŕa NUll ( SQL ERROR )
        receitaRepository.saveAll(refeicao.getOpcoes());

        return refeicaorepository.save(refeicao);
    }

    public void saveAll(List<Refeicao> refeicoes){
        for (Refeicao ref: refeicoes){
            this.save(ref);
        }
    }


}
