package com.example.demo.dto;

import com.example.demo.model.Receita;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RefeicaoDTO {
    private String nome;
    private List<Receita> opcoes;
    private String hora;

    public RefeicaoDTO( String nome, List<Receita> opcoes, String hora ) {
        this.nome = nome;
        this.opcoes = opcoes;
        this.hora =  hora ;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Receita> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Receita> opcoes) {
        this.opcoes = opcoes;
    }

    public String getHora() {
        return hora;
    }

    public void setHorario(String hora) {
        this.hora = hora;
    }
}
