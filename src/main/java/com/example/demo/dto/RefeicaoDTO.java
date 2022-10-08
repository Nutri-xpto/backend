package com.example.demo.dto;

import java.util.List;

public class RefeicaoDTO {
    private String nome;
    private List<String> alimentos; 
    private String horario; 

    public RefeicaoDTO( String nome, List<String> alimentos, String horario ) {
        this.nome = nome;
        this.alimentos = alimentos;
        this.horario =  horario ;
    }

    public String getNome() { return nome; }

    public List<String> getAlimentos() { return alimentos; }

    public String getHorario() { return horario; }

    public void setNome(String nome) { this.nome = nome;}

    public void setAlimentos( List<String> alimentos ) { this.alimentos = alimentos; }

    public void setHorario( String horario ) { this.horario = horario; }

}
